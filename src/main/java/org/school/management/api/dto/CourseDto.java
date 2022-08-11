package org.school.management.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.school.management.api.entities.Student;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseDto {

    private Long id;

    private String name;

    private String description;

    private String level;

    private Set<Student> students = new HashSet<>();
}
