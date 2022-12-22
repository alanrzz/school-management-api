package org.school.management.api.services.impl;

import org.school.management.api.dto.AttendanceDto;
import org.school.management.api.entities.Attendance;
import org.school.management.api.exceptions.ResourceNotFoundException;
import org.school.management.api.repositories.AttendanceRepository;
import org.school.management.api.services.AttendanceService;
import org.school.management.api.services.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private ConvertService convertService;

    @Override
    public HashMap<String, Object> findAll(Pageable pageable) throws Exception {
        return this.convertService.convertToAttendanceFormat(this.attendanceRepository.findAll(pageable));
    }

    @Override
    public AttendanceDto findById(Long id) throws Exception {
        return this.convertService.convertToDto(this.findOrFail(id));
    }

    @Override
    public AttendanceDto create(AttendanceDto attendanceDto) throws Exception {
        return this.convertService.convertToDto(this.attendanceRepository.save(this.convertService.convertToEntity(attendanceDto)));
    }

    @Override
    public AttendanceDto edit(Long id, AttendanceDto attendanceDto) throws Exception {
        this.findOrFail(id);
        Attendance attendance = this.convertService.convertToEntity(attendanceDto);
        attendance.setId(id);
        return this.convertService.convertToDto(this.attendanceRepository.save(attendance));
    }

    @Override
    public String delete(Long id) throws Exception {
        this.attendanceRepository.delete(this.findOrFail(id));
        return "Asistencia eliminada.";
    }

    private Attendance findOrFail(Long id) {
        return this.attendanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe una asistencia con ID = " + id + "."));
    }
}
