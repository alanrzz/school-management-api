package org.school.management.api.services.impl;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.school.management.api.dto.StudentDto;
import org.school.management.api.repositories.StudentRepository;
import org.school.management.api.services.ConvertService;
import org.school.management.api.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.school.management.api.enums.Reports.CONTENT_DISPOSITION_FORM_DATA;
import static org.school.management.api.enums.Reports.IN_EXTENSION;
import static org.school.management.api.enums.Reports.OUT_EXTENSION;
import static org.school.management.api.enums.Reports.REPORTS_FOLDER;
import static org.school.management.api.enums.Reports.STUDENTS_REPORT;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    ConvertService convertService;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public ResponseEntity<Object> generateStudentsReport() {
        List<StudentDto> students = this.studentRepository.findAll().stream().map(convertService::convertToDto).collect(Collectors.toList());
        Map<String,Object> params = new HashMap<>();
        params.put("students", new JRBeanCollectionDataSource(students));
        return generateReport(STUDENTS_REPORT.getName(), params, new JREmptyDataSource());
    }

    private ResponseEntity<Object> generateReport(String filename, Map<String, Object> params, JRDataSource datasource) {
        try {
            String filenameFromResource = REPORTS_FOLDER.getName() + filename + IN_EXTENSION.getName();
            String outFilename = filename + OUT_EXTENSION.getName();
            JasperReport jasperReport = JasperCompileManager.compileReport(getFileFromResource(filenameFromResource).getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData(CONTENT_DISPOSITION_FORM_DATA.getName(), outFilename);
            return new ResponseEntity<>(JasperExportManager.exportReportToPdf(jasperPrint), headers, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private File getFileFromResource(String filename) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(filename);
        if (resource == null)
            throw new IllegalArgumentException("No se encontro el archivo: " + filename);
        else
            return new File(resource.toURI());
    }
}
