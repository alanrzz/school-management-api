package org.school.management.api.controllers;

import org.school.management.api.dto.requests.UserCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface UserController {

    ResponseEntity<Object> create(@Valid @RequestBody UserCreateRequest userCreateRequest) throws Exception;

}
