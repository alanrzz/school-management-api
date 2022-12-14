package org.school.management.api.services.impl;

import org.school.management.api.dto.MessageResponseDto;
import org.school.management.api.dto.StudentDto;
import org.school.management.api.entities.Course;
import org.school.management.api.entities.Student;
import org.school.management.api.exceptions.ResourceNotFoundException;
import org.school.management.api.repositories.StudentRepository;
import org.school.management.api.services.ConvertService;
import org.school.management.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ConvertService convertService;

    @Override
    public HashMap<String, Object> findAll(Pageable pageable) {
        return this.convertService.convertToStudentFormat(this.studentRepository.findAll(pageable));
    }

    @Override
    public StudentDto findById(Long id) {
        return this.convertService.convertToDto(this.findOrFail(id));
    }

    @Override
    public StudentDto create(StudentDto studentDto) {
        return this.convertService.convertToDto(this.studentRepository.save(this.convertService.convertToEntity(studentDto)));
    }

    @Override
    public StudentDto edit(Long id, StudentDto studentDto) {
        this.findOrFail(id);
        Student student = this.convertService.convertToEntity(studentDto);
        student.setId(id);
        return this.convertService.convertToDto(this.studentRepository.save(student));
    }

    @Override
    public MessageResponseDto delete(Long id) {
        Student student = this.findOrFail(id);
        for (Course course : student.getCourses())
            student.removeCourse(course);
        this.studentRepository.deleteById(id);
        return new MessageResponseDto(HttpStatus.OK, "Estudiante eliminado exitosamente!");
    }

    private Student findOrFail(Long id) {
        return this.studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe un estudiante con ID = " + id + "."));
    }
}
