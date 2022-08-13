package org.school.management.api.services.impl;

import org.school.management.api.dto.TeacherDto;
import org.school.management.api.entities.Course;
import org.school.management.api.entities.Teacher;
import org.school.management.api.exceptions.ResourceNotFoundException;
import org.school.management.api.repositories.TeacherRepository;
import org.school.management.api.services.ConvertService;
import org.school.management.api.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ConvertService convertService;

    @Override
    public List<TeacherDto> findAll() {
        return this.teacherRepository.findAll().stream().map(this.convertService::convertToDto).toList();
    }

    @Override
    public TeacherDto findById(Long id) {
        return this.convertService.convertToDto(this.findOrFail(id));
    }

    @Override
    public TeacherDto create(TeacherDto teacherDto) {
        return this.convertService.convertToDto(this.teacherRepository.save(this.convertService.convertToEntity(teacherDto)));
    }

    @Override
    public TeacherDto edit(Long id, TeacherDto teacherDto) {
        this.findOrFail(id);
        Teacher teacher = this.convertService.convertToEntity(teacherDto);
        teacher.setId(id);
        return this.convertService.convertToDto(this.teacherRepository.save(teacher));
    }

    @Override
    public String delete(Long id) {
        Teacher teacher = this.findOrFail(id);
        for (Course course : teacher.getCourses())
            teacher.removeCourse(course);
        this.teacherRepository.deleteById(id);
        return "Profesor eliminado.";
    }

    private Teacher findOrFail(Long id) {
        return this.teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe un profesor con ID = " + id));
    }
}
