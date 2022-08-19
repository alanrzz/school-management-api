package org.school.management.api.dto.requests;

import lombok.Data;

@Data
public class UserCreateRequest {

    private String username;

    private String password;
}
