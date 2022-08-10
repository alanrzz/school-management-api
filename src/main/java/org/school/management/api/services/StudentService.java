package org.school.management.api.services;

import org.school.management.api.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> findAll() throws Exception;

    StudentDto findById(Long id) throws Exception;

    StudentDto create(StudentDto studentDto) throws Exception;

    StudentDto edit(Long id, StudentDto studentDto) throws Exception;

    String delete(Long id) throws Exception;
}
