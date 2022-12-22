package org.school.management.api.services.impl;

import org.school.management.api.dto.JwtResponseDto;
import org.school.management.api.dto.LoginRequestDto;
import org.school.management.api.dto.SignupRequestDto;
import org.school.management.api.entities.Role;
import org.school.management.api.entities.User;
import org.school.management.api.enums.UserRole;
import org.school.management.api.exceptions.AlreadyExistsException;
import org.school.management.api.exceptions.ResourceNotFoundException;
import org.school.management.api.repositories.RoleRepository;
import org.school.management.api.repositories.UserRepository;
import org.school.management.api.security.JwtUtils;
import org.school.management.api.security.UserDetailsImpl;
import org.school.management.api.services.AuthenticationService;
import org.school.management.api.services.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

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

    @Autowired
    ConvertService convertService;

    @Override
    public ResponseEntity<?> authenticate(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponseDto(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles, jwt,"Bearer"));
    }

    @Override
    public ResponseEntity<?> register(SignupRequestDto signupRequestDto) {
        validateCredentials(signupRequestDto);
        User user = new User(signupRequestDto.getUsername(),
                signupRequestDto.getEmail(), this.encoder.encode(signupRequestDto.getPassword()));
        user.setRoles(buildRoles(signupRequestDto.getRoles()));
        return ResponseEntity.ok(this.convertService.convertToDto(this.userRepository.save(user)));
    }

    private void validateCredentials(SignupRequestDto signupRequestDto){
        if(this.userRepository.existsByUsername(signupRequestDto.getUsername()))
            throw new AlreadyExistsException("El nombre de usuario ya está en uso!");
        if(this.userRepository.existsByEmail(signupRequestDto.getEmail()))
            throw new AlreadyExistsException("El correo electrónico ya está en uso!");
        if(signupRequestDto.getRoles() == null || signupRequestDto.getRoles().isEmpty())
            throw new ResourceNotFoundException("El usuario debe tener un rol!");
    }

    private Set<Role> buildRoles(Set<String> roles) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roles) {
            switch (role.toUpperCase()) {
                case "ROLE_USER", "USER" -> {
                    Role userRole = findRoleOrFail(UserRole.ROLE_USER);
                    roleSet.add(userRole);
                }
                case "ROLE_MODERATOR", "MODERATOR" -> {
                    Role modRole = findRoleOrFail(UserRole.ROLE_MODERATOR);
                    roleSet.add(modRole);
                }
                case "ROLE_ADMIN", "ADMIN" -> {
                    Role adminRole = findRoleOrFail(UserRole.ROLE_ADMIN);
                    roleSet.add(adminRole);
                }
                default -> throw new ResourceNotFoundException("El rol = " + role + ", aún no fue creado. Comuníquese con el administrador!");
            }
        }
        return roleSet;
    }

    private Role findRoleOrFail(UserRole role) {
        return this.roleRepository.findByName(role)
                .orElseThrow(() -> new ResourceNotFoundException("No existe un rol con el nombre = " + role + "."));
    }
}
