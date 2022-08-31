package org.school.management.api.controllers.impl;

import org.school.management.api.controllers.ReportController;
import org.school.management.api.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportControllerImpl implements ReportController {

    @Autowired
    private ReportService reportService;

    @Override
    @GetMapping("students")
    public ResponseEntity<Object> generateStudentsReport() throws Exception {
        return new ResponseEntity<>(this.reportService.generateStudentsReport(), HttpStatus.OK) ;
    }
}
