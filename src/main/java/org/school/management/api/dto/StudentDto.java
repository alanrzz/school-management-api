package org.school.management.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.school.management.api.entities.Course;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDto {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String gender;

    private Integer age;

    private String address;

    @JsonIgnore
    private Set<Course> courses = new HashSet<>();
}
