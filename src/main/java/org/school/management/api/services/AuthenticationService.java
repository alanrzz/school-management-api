package org.school.management.api.services;

import org.school.management.api.dto.LoginRequestDto;
import org.school.management.api.dto.SignupRequestDto;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

    ResponseEntity<?> register(SignupRequestDto signupRequestDto);

    ResponseEntity<?> authenticate(LoginRequestDto loginRequestDto);
}
