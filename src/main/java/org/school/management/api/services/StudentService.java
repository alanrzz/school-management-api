package org.school.management.api.services;

import org.school.management.api.dto.MessageResponseDto;
import org.school.management.api.dto.StudentDto;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;

public interface StudentService {

    HashMap<String, Object> findAll(Pageable pageable) throws Exception;

    StudentDto findById(Long id) throws Exception;

    StudentDto create(StudentDto studentDto) throws Exception;

    StudentDto edit(Long id, StudentDto studentDto) throws Exception;

    MessageResponseDto delete(Long id) throws Exception;
}
