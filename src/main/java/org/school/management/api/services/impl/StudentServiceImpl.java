package org.school.management.api.services.impl;

import org.school.management.api.dto.StudentDto;
import org.school.management.api.entities.Student;
import org.school.management.api.repositories.StudentRepository;
import org.school.management.api.services.ConvertService;
import org.school.management.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ConvertService convertService;

    @Override
    public List<StudentDto> findAll() {
        return this.studentRepository.findAll().stream().map(this.convertService::convertToDto).toList();
    }

    @Override
    public StudentDto findById(Long id) throws Exception {
        return this.convertService.convertToDto(this.studentRepository.findById(id)
                .orElseThrow(() -> new Exception("No existe un estudiante con ID = " + id)));
    }

    @Override
    public StudentDto create(StudentDto studentDto) {
        return this.convertService.convertToDto(this.studentRepository.save(this.convertService.convertToEntity(studentDto)));
    }

    @Override
    public StudentDto edit(Long id, StudentDto studentDto) {
        Student student = this.convertService.convertToEntity(studentDto);
        student.setId(id);
        return this.convertService.convertToDto(this.studentRepository.save(student));
    }

    @Override
    public String delete(Long id) {
        this.studentRepository.deleteById(id);
        return "Estudiante eliminado.";
    }
}
