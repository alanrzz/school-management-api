package org.school.management.api.services;

import org.school.management.api.dto.StudentDto;
import org.school.management.api.dto.TeacherDto;
import org.school.management.api.entities.Student;
import org.school.management.api.entities.Teacher;

public interface ConvertService {

    Student convertToEntity(StudentDto studentDto);

    StudentDto convertToDto(Student student);

    Teacher convertToEntity(TeacherDto teacherDto);

    TeacherDto convertToDto(Teacher teacher);
}
