package org.school.management.api.controllers.impl;

import org.school.management.api.controllers.CourseController;
import org.school.management.api.dto.CourseDto;
import org.school.management.api.services.CourseService;
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
@RequestMapping("/courses")
public class CourseControllerImpl implements CourseController {

    @Autowired
    private CourseService courseService;

    @Override
    @GetMapping
    public List<CourseDto> findAll() throws Exception {
        return this.courseService.findAll();
    }

    @Override
    @GetMapping(value = "{id}")
    public CourseDto findById(Long id) throws Exception {
        return this.courseService.findById(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<CourseDto> create(CourseDto courseDto) throws Exception {
        return new ResponseEntity<>(this.courseService.create(courseDto), HttpStatus.CREATED);
    }

    @Override
    @PutMapping(value= "{id}")
    public ResponseEntity<CourseDto> edit(Long id, CourseDto courseDto) throws Exception {
        return new ResponseEntity<>(this.courseService.edit(id,courseDto), HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value= "{id}")
    public ResponseEntity<String> delete(Long id) throws Exception {
        return new ResponseEntity<>(this.courseService.delete(id), HttpStatus.OK);
    }
}
