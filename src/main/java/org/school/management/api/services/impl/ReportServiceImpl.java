package org.school.management.api.services.impl;

import net.sf.jasperreports.engine.JRDataSource;
import org.school.management.api.services.ReportService;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class ReportServiceImpl implements ReportService {

    private static final String STUDENT_REPORT = "StudentReport";

    @Override
    public ResponseEntity<Object> generateStudentsReport() throws Exception {
        // TODO
        return null;
    }

    private ResponseEntity<Object> generateReport(String sourceFilename, Map<String, Object> params, JRDataSource dataSource) {
        // TODO
        return null;
    }
}
