package org.school.management.api.services.impl;

import org.school.management.api.dto.CourseDto;
import org.school.management.api.entities.Course;
import org.school.management.api.repositories.CourseRepository;
import org.school.management.api.services.ConvertService;
import org.school.management.api.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ConvertService convertService;

    @Override
    public List<CourseDto> findAll() {
        return this.courseRepository.findAll().stream().map(this.convertService::convertToDto).toList();
    }

    @Override
    public CourseDto findById(Long id) throws Exception {
        return this.convertService.convertToDto(this.courseRepository.findById(id)
                .orElseThrow(() -> new Exception("No existe un curso con ID = " + id)));
    }

    @Override
    public CourseDto create(CourseDto courseDto) {
        return this.convertService.convertToDto(this.courseRepository.save(this.convertService.convertToEntity(courseDto)));
    }

    @Override
    public CourseDto edit(Long id, CourseDto courseDto) {
        Course course = this.convertService.convertToEntity(courseDto);
        course.setId(id);
        return this.convertService.convertToDto(this.courseRepository.save(course));
    }

    @Override
    public String delete(Long id) {
        this.courseRepository.deleteById(id);
        return "Curso eliminado.";
    }
}
