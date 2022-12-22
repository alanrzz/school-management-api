package org.school.management.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.school.management.api.dto.AttendanceDto;
import org.school.management.api.dto.MessageResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.HashMap;

@Api(value = "Attendance operations", tags = "Attendance")
public interface AttendanceController {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataTypeClass = Integer.class, paramType = "query", value = "Número de página.", defaultValue = "0", example = "0"),
            @ApiImplicitParam(name = "size", dataTypeClass = Integer.class, paramType = "query", value = "Número de registros por página.", defaultValue = "10", example = "10"),
            @ApiImplicitParam(name = "sort", dataTypeClass = String.class, paramType = "query", value = "Criterio de ordenamiento en formato: propiedades (,asc | ,desc)."
                    + "\nPor defecto es: id,desc.", defaultValue = "id,desc")})
    @ApiOperation(value = "Obtener todas las asistencias.")
    HashMap<String, Object> findAll(@ApiIgnore @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) throws Exception;

    @ApiOperation(value = "Buscar una asistencia.", response = AttendanceDto.class)
    AttendanceDto findById(@PathVariable("id") Long id) throws Exception;

    @ApiOperation(value = "Registrar una nueva asistencia.")
    ResponseEntity<AttendanceDto> create(@Valid @RequestBody AttendanceDto attendanceDto) throws Exception;

    @ApiOperation(value = "Editar una asistencia.")
    ResponseEntity<AttendanceDto> edit(@PathVariable("id") Long id, @Valid @RequestBody AttendanceDto attendanceDto) throws Exception;

    @ApiOperation(value = "Eliminar un asistencia.")
    ResponseEntity<MessageResponseDto> delete(@PathVariable("id") Long id) throws Exception;
}
