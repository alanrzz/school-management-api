package org.school.management.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeacherDto {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String gender;

    private Integer age;

    private String address;
}
