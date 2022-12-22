package org.school.management.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.school.management.api.dto.LoginRequestDto;
import org.school.management.api.dto.SignupRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Api(value = "Authentication operations", tags = "Authentication")
public interface AuthenticationController {

    @ApiOperation(value = "Autenticar un usuario.", response = ResponseEntity.class)
    ResponseEntity<?> authenticate(@Valid @RequestBody LoginRequestDto loginRequestDto);

    @ApiOperation(value = "Registrar un usuario.", response = ResponseEntity.class)
    ResponseEntity<?> register(@Valid @RequestBody SignupRequestDto signupRequestDto);
}