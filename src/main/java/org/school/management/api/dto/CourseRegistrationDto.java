package org.school.management.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.school.management.api.entities.Course;
import org.school.management.api.entities.Student;
import org.school.management.api.entities.Teacher;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseRegistrationDto {

    private Long id;

    private Student student;

    private Course course;

    private Teacher teacher;

    private LocalDateTime createdDate;
}
