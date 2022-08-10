package org.school.management.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.school.management.api.dto.StudentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Student operations", tags = "Student")
public interface StudentController {

    @ApiOperation(value = "Obtener todos los estudiantes.")
    List<StudentDto> findAll() throws Exception;

    @ApiOperation(value = "Buscar un estudiante.", response = StudentDto.class)
    StudentDto findById(@PathVariable("id") Long id) throws Exception;

    @ApiOperation(value = "Registrar un nuevo estudiante.")
    ResponseEntity<StudentDto> create(@Valid @RequestBody StudentDto studentDto) throws Exception;

    @ApiOperation(value = "Editar un estudiante.")
    ResponseEntity<StudentDto> edit(@PathVariable("id") Long id, @Valid @RequestBody StudentDto studentDto) throws Exception;

    @ApiOperation(value = "Eliminar un estudiante.")
    ResponseEntity<String> delete(@PathVariable("id") Long id) throws Exception;
}
