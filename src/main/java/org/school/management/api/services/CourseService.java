package org.school.management.api.services;

import org.school.management.api.dto.CourseDto;

import java.util.List;

public interface CourseService {

    List<CourseDto> findAll() throws Exception;

    CourseDto findById(Long id) throws Exception;

    CourseDto create(CourseDto courseDto) throws Exception;

    CourseDto edit(Long id, CourseDto courseDto) throws Exception;

    String delete(Long id) throws Exception;
}
