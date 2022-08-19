package org.school.management.api.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.school.management.api.controllers.UserController;
import org.school.management.api.dto.requests.UserCreateRequest;
import org.school.management.api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    @PostMapping
    public ResponseEntity<Object> create(UserCreateRequest userCreateRequest) throws Exception {
        this.userService.create(userCreateRequest);
        return ResponseEntity.ok().build();
    }
}
