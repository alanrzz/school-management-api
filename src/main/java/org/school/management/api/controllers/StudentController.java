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
    List<StudentDto> list() throws Exception;

    @ApiOperation(value = "Buscar un estudiante por ID.", response = StudentDto.class)
    StudentDto showStudent(@PathVariable("id") Long id) throws Exception;

    @ApiOperation(value = "Registrar un nuevo estudiante.")
    ResponseEntity<StudentDto> save(@Valid @RequestBody StudentDto studentDto) throws Exception;

    @ApiOperation(value = "Actualizar un estudiante.")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long id, @Valid @RequestBody StudentDto studentDto) throws Exception;

    @ApiOperation(value = "Eliminar un estudiante.")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) throws Exception;
}
