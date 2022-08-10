package org.school.management.api.services.impl;

import org.modelmapper.ModelMapper;
import org.school.management.api.dto.StudentDto;
import org.school.management.api.entities.Student;
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
}
