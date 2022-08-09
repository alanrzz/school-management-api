package org.school.management.api.controllers.impl;

import org.school.management.api.controllers.StudentController;
import org.school.management.api.dto.StudentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentControllerImpl implements StudentController {

    @Override
    @GetMapping
    public List<StudentDto> list() throws Exception {
        return null;
    }

    @Override
    @GetMapping(value = "{id}")
    public StudentDto showStudent(Long id) throws Exception {
        return null;
    }

    @Override
    @PostMapping
    public ResponseEntity<StudentDto> save(StudentDto studentDto) throws Exception {
        return null;
    }

    @Override
    @PutMapping(value= "{id}")
    public ResponseEntity<StudentDto> updateStudent(Long id, StudentDto studentDto) throws Exception {
        return null;
    }

    @Override
    @DeleteMapping(value= "{id}")
    public ResponseEntity<String> deleteStudent(Long id) throws Exception {
        return null;
    }
}
