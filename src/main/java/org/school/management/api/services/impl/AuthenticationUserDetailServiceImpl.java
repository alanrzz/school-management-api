package org.school.management.api.services.impl;

import lombok.RequiredArgsConstructor;
import org.school.management.api.exceptions.ResourceNotFoundException;
import org.school.management.api.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationUserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.school.management.api.entities.User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el nombre de usuario = " + username));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
