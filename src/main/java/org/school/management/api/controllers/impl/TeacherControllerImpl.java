package org.school.management.api.controllers.impl;

import org.school.management.api.controllers.TeacherController;
import org.school.management.api.dto.TeacherDto;
import org.school.management.api.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherControllerImpl implements TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Override
    @GetMapping
    public List<TeacherDto> findAll() throws Exception {
        return this.teacherService.findAll();
    }

    @Override
    @GetMapping(value = "{id}")
    public TeacherDto findById(Long id) throws Exception {
        return this.teacherService.findById(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<TeacherDto> create(TeacherDto teacherDto) throws Exception {
        return new ResponseEntity<>(this.teacherService.create(teacherDto), HttpStatus.CREATED);
    }

    @Override
    @PutMapping(value= "{id}")
    public ResponseEntity<TeacherDto> edit(Long id, TeacherDto teacherDto) throws Exception {
        return new ResponseEntity<>(this.teacherService.edit(id,teacherDto), HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value= "{id}")
    public ResponseEntity<String> delete(Long id) throws Exception {
        return new ResponseEntity<>(this.teacherService.delete(id), HttpStatus.OK);
    }
}
