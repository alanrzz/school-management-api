package org.school.management.api.services;

import org.springframework.http.ResponseEntity;

public interface ReportService {

    ResponseEntity<Object> generateStudentsReport() throws Exception;

    ResponseEntity<Object> generateTeachersReport() throws Exception;
}
