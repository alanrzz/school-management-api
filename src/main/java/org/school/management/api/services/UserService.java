package org.school.management.api.services;

import org.school.management.api.dto.requests.UserCreateRequest;

public interface UserService {

/*
    User findByUsername(String username) throws Exception;;
*/

    void create(UserCreateRequest userCreateRequest) throws Exception;;
}
