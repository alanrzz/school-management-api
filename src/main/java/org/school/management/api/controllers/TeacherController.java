package org.school.management.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.school.management.api.dto.TeacherDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.HashMap;

@Api(value = "Teacher operations", tags = "Teacher")
public interface TeacherController {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Número de página (0..N).", defaultValue = "0"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Número de registros por página.", defaultValue = "10"),
            @ApiImplicitParam(name = "sort", dataType = "integer", paramType = "query", value = "Criterio de ordenamiento en formato: propiedades(,asc | ,desc)."
                    + "Orden por defecto es ID DESC.\nOrdenamiento con múltiples criterios es soportado.", defaultValue = "id,desc")})
    @ApiOperation(value = "Obtener todos los profesores.")
    HashMap<String, Object> findAll(@ApiIgnore @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) throws Exception;

    @ApiOperation(value = "Buscar un profesor.", response = TeacherDto.class)
    TeacherDto findById(@PathVariable("id") Long id) throws Exception;

    @ApiOperation(value = "Registrar un nuevo profesor.")
    ResponseEntity<TeacherDto> create(@Valid @RequestBody TeacherDto teacherDto) throws Exception;

    @ApiOperation(value = "Editar un profesor.")
    ResponseEntity<TeacherDto> edit(@PathVariable("id") Long id, @Valid @RequestBody TeacherDto teacherDto) throws Exception;

    @ApiOperation(value = "Eliminar un profesor.")
    ResponseEntity<String> delete(@PathVariable("id") Long id) throws Exception;
}
