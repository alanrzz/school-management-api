package org.school.management.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.school.management.api.dto.TeacherDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Teacher operations", tags = "Teacher")
public interface TeacherController {

    @ApiOperation(value = "Obtener todos los profesores.")
    List<TeacherDto> findAll() throws Exception;

    @ApiOperation(value = "Buscar un profesor.", response = TeacherDto.class)
    TeacherDto findById(@PathVariable("id") Long id) throws Exception;

    @ApiOperation(value = "Registrar un nuevo profesor.")
    ResponseEntity<TeacherDto> create(@Valid @RequestBody TeacherDto teacherDto) throws Exception;

    @ApiOperation(value = "Editar un profesor.")
    ResponseEntity<TeacherDto> edit(@PathVariable("id") Long id, @Valid @RequestBody TeacherDto teacherDto) throws Exception;

    @ApiOperation(value = "Eliminar un profesor.")
    ResponseEntity<String> delete(@PathVariable("id") Long id) throws Exception;
}
