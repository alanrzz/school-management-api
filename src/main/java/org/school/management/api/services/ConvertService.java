package org.school.management.api.services;

import org.school.management.api.dto.StudentDto;
import org.school.management.api.entities.Student;

public interface ConvertService {

    Student convertToEntity(StudentDto studentDto);

    StudentDto convertToDto(Student student);
}
