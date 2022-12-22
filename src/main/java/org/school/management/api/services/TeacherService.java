package org.school.management.api.services;

import org.school.management.api.dto.MessageResponseDto;
import org.school.management.api.dto.TeacherDto;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;

public interface TeacherService {

    HashMap<String, Object> findAll(Pageable pageable) throws Exception;

    TeacherDto findById(Long id) throws Exception;

    TeacherDto create(TeacherDto teacherDto) throws Exception;

    TeacherDto edit(Long id, TeacherDto teacherDto) throws Exception;

    MessageResponseDto delete(Long id) throws Exception;
}
