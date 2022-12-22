package org.school.management.api.services;

import org.school.management.api.dto.AttendanceDto;
import org.school.management.api.dto.MessageResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;

public interface AttendanceService {

    HashMap<String, Object> findAll(Pageable pageable) throws Exception;

    AttendanceDto findById(Long id) throws Exception;

    AttendanceDto create(AttendanceDto attendanceDto) throws Exception;

    AttendanceDto edit(Long id, AttendanceDto attendanceDto) throws Exception;

    MessageResponseDto delete(Long id) throws Exception;
}
