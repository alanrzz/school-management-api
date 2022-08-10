package org.school.management.api.services.impl;

import org.modelmapper.ModelMapper;
import org.school.management.api.dto.CourseDto;
import org.school.management.api.dto.StudentDto;
import org.school.management.api.dto.TeacherDto;
import org.school.management.api.entities.Course;
import org.school.management.api.entities.Student;
import org.school.management.api.entities.Teacher;
import org.school.management.api.services.ConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService {

    @Override
    public Student convertToEntity(StudentDto studentDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(studentDto, Student.class);
    }

    @Override
    public StudentDto convertToDto(Student student) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public Teacher convertToEntity(TeacherDto teacherDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(teacherDto, Teacher.class);
    }

    @Override
    public TeacherDto convertToDto(Teacher teacher) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(teacher, TeacherDto.class);
    }

    @Override
    public Course convertToEntity(CourseDto courseDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(courseDto, Course.class);
    }

    @Override
    public CourseDto convertToDto(Course course) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(course, CourseDto.class);
    }
}
