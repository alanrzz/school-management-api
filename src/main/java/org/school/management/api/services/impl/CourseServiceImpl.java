package org.school.management.api.services.impl;

import org.school.management.api.dto.CourseDto;
import org.school.management.api.entities.Course;
import org.school.management.api.exceptions.ResourceNotFoundException;
import org.school.management.api.repositories.CourseRepository;
import org.school.management.api.services.ConvertService;
import org.school.management.api.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ConvertService convertService;

    @Override
    public HashMap<String, Object> findAll(Pageable pageable) {
        return this.convertService.convertToCourseFormat(this.courseRepository.findAll(pageable));
    }

    @Override
    public CourseDto findById(Long id) {
        return this.convertService.convertToDto(this.findOrFail(id));
    }

    @Override
    public CourseDto create(CourseDto courseDto) {
        return this.convertService.convertToDto(this.courseRepository.save(this.convertService.convertToEntity(courseDto)));
    }

    @Override
    public CourseDto edit(Long id, CourseDto courseDto) {
        this.findOrFail(id);
        Course course = this.convertService.convertToEntity(courseDto);
        course.setId(id);
        return this.convertService.convertToDto(this.courseRepository.save(course));
    }

    @Override
    public String delete(Long id) {
        this.courseRepository.delete(this.findOrFail(id));
        return "Curso eliminado.";
    }

    private Course findOrFail(Long id) {
        return this.courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe un curso con ID = " + id + "."));
    }
}
