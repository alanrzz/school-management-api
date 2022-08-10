package org.school.management.api.services;

import org.school.management.api.dto.TeacherDto;

import java.util.List;

public interface TeacherService {

    List<TeacherDto> findAll() throws Exception;

    TeacherDto findById(Long id) throws Exception;

    TeacherDto create(TeacherDto teacherDto) throws Exception;

    TeacherDto edit(Long id, TeacherDto teacherDto) throws Exception;

    String delete(Long id) throws Exception;
}
