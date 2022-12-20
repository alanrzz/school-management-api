package org.school.management.api.controllers.impl;

import org.school.management.api.controllers.AuthController;
import org.school.management.api.dto.JwtResponseDto;
import org.school.management.api.dto.LoginRequestDto;
import org.school.management.api.dto.SignupRequestDto;
import org.school.management.api.entities.Role;
import org.school.management.api.entities.User;
import org.school.management.api.enums.UserRole;
import org.school.management.api.error.ApiError;
import org.school.management.api.repositories.RoleRepository;
import org.school.management.api.repositories.UserRepository;
import org.school.management.api.security.JwtUtils;
import org.school.management.api.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthControllerImpl implements AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    @PostMapping("/login")
    public ResponseEntity<?> authenticate(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponseDto(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles, jwt));
    }

    @Override
    @PostMapping("/signup")
    public ResponseEntity<?> register(SignupRequestDto signupRequestDto) {
        ApiError apiError = new ApiError(HttpStatus.OK);
        apiError.setMessage("Usuario registrado con éxito!");

        if (userRepository.existsByUsername(signupRequestDto.getUsername())) {
            apiError.setStatus(HttpStatus.BAD_REQUEST);
            apiError.setMessage("Error: El nombre de usuario ya está en uso!");
            return ResponseEntity.badRequest().body(apiError);
        }

        if (userRepository.existsByEmail(signupRequestDto.getEmail())) {
            apiError.setStatus(HttpStatus.BAD_REQUEST);
            apiError.setMessage("Error: El correo electrónico ya está en uso!");
            return ResponseEntity.badRequest().body(apiError);
        }

        // Create new user's account
        User user = new User(signupRequestDto.getUsername(), signupRequestDto.getEmail(), encoder.encode(signupRequestDto.getPassword()));

        Set<String> strRoles = signupRequestDto.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(UserRole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: No se ha encontrado el rol proporcionado."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin" -> {
                        Role adminRole = roleRepository.findByName(UserRole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: No se ha encontrado el rol proporcionado."));
                        roles.add(adminRole);
                    }
                    case "mod" -> {
                        Role modRole = roleRepository.findByName(UserRole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: No se ha encontrado el rol proporcionado."));
                        roles.add(modRole);
                    }
                    default -> {
                        Role userRole = roleRepository.findByName(UserRole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: No se ha encontrado el rol proporcionado."));
                        roles.add(userRole);
                    }
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(apiError);
    }
}
