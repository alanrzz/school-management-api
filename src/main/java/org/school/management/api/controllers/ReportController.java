package org.school.management.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

@Api(value = "Report operations", tags = "Report")
public interface ReportController {

    @ApiOperation(value = "Generar reporte de estudiantes.")
    ResponseEntity<Object> generateStudentsReport() throws Exception;
}
