package org.school.management.api.controllers.impl;

import org.school.management.api.controllers.StudentController;
import org.school.management.api.dto.StudentDto;
import org.school.management.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/students")
public class StudentControllerImpl implements StudentController {

    @Autowired
    private StudentService studentService;

    @Override
    @GetMapping
    public HashMap<String, Object> findAll(Pageable pageable) throws Exception {
        return this.studentService.findAll(pageable);
    }

    @Override
    @GetMapping(value = "{id}")
    public StudentDto findById(Long id) throws Exception {
        return this.studentService.findById(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<StudentDto> create(StudentDto studentDto) throws Exception {
        return new ResponseEntity<>(this.studentService.create(studentDto), HttpStatus.CREATED);
    }

    @Override
    @PutMapping(value= "{id}")
    public ResponseEntity<StudentDto> edit(Long id, StudentDto studentDto) throws Exception {
        return new ResponseEntity<>(this.studentService.edit(id,studentDto), HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value= "{id}")
    public ResponseEntity<String> delete(Long id) throws Exception {
        return new ResponseEntity<>(this.studentService.delete(id), HttpStatus.OK);
    }
}
