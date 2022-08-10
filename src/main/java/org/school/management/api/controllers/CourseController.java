package org.school.management.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.school.management.api.dto.CourseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Course operations", tags = "Course")
public interface CourseController {

    @ApiOperation(value = "Obtener todos los cursos.")
    List<CourseDto> findAll() throws Exception;

    @ApiOperation(value = "Buscar un curso.", response = CourseDto.class)
    CourseDto findById(@PathVariable("id") Long id) throws Exception;

    @ApiOperation(value = "Registrar un nuevo curso.")
    ResponseEntity<CourseDto> create(@Valid @RequestBody CourseDto courseDto) throws Exception;

    @ApiOperation(value = "Editar un curso.")
    ResponseEntity<CourseDto> edit(@PathVariable("id") Long id, @Valid @RequestBody CourseDto courseDto) throws Exception;

    @ApiOperation(value = "Eliminar un curso.")
    ResponseEntity<String> delete(@PathVariable("id") Long id) throws Exception;
}
