package org.school.management.api.services.impl;

import lombok.RequiredArgsConstructor;
import org.school.management.api.dto.requests.UserCreateRequest;
import org.school.management.api.entities.User;
import org.school.management.api.exceptions.ResourceAlreadyExists;
import org.school.management.api.repositories.UserRepository;
import org.school.management.api.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /*@Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("No existe el nombre de usuario = " + username));
    }*/

    @Override
    public void create(UserCreateRequest userCreateRequest) throws Exception {
        User user = new User();

        if(userRepository.findByUsername(userCreateRequest.getUsername()).isPresent())
            throw new ResourceAlreadyExists("El nombre de usuario ya existe. Por favor, elija uno diferente.");

        user.setUsername(userCreateRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userCreateRequest.getPassword()));
        this.userRepository.save(user);
    }
}
