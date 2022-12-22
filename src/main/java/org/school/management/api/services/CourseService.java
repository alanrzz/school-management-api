package org.school.management.api.services;

import org.school.management.api.dto.CourseDto;
import org.school.management.api.dto.MessageResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;

public interface CourseService {

    HashMap<String, Object> findAll(Pageable pageable) throws Exception;

    CourseDto findById(Long id) throws Exception;

    CourseDto create(CourseDto courseDto) throws Exception;

    CourseDto edit(Long id, CourseDto courseDto) throws Exception;

    MessageResponseDto delete(Long id) throws Exception;
}
