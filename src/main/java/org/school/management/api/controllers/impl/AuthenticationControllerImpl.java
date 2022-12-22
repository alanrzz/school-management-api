package org.school.management.api.controllers.impl;

import org.school.management.api.controllers.AuthenticationController;
import org.school.management.api.dto.LoginRequestDto;
import org.school.management.api.dto.SignupRequestDto;
import org.school.management.api.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/authentication")
public class AuthenticationControllerImpl implements AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @Override
    @PostMapping("/login")
    public ResponseEntity<?> authenticate(LoginRequestDto loginRequestDto) {
        return this.authenticationService.authenticate(loginRequestDto);
    }

    @Override
    @PostMapping("/signup")
    public ResponseEntity<?> register(SignupRequestDto signupRequestDto) {
        return this.authenticationService.register(signupRequestDto);
    }
}
