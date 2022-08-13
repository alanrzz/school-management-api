package org.school.management.api.services;

import org.school.management.api.dto.CourseDto;
import org.school.management.api.dto.StudentDto;
import org.school.management.api.dto.TeacherDto;
import org.school.management.api.entities.Course;
import org.school.management.api.entities.Student;
import org.school.management.api.entities.Teacher;

public interface ConvertService {

    Student convertToEntity(StudentDto studentDto);

    StudentDto convertToDto(Student student);

    Teacher convertToEntity(TeacherDto teacherDto);

    TeacherDto convertToDto(Teacher teacher);

    Course convertToEntity(CourseDto courseDto);

    CourseDto convertToDto(Course course);
}