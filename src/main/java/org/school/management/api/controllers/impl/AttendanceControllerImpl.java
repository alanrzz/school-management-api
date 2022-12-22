package org.school.management.api.controllers.impl;

import org.school.management.api.controllers.AttendanceController;
import org.school.management.api.dto.AttendanceDto;
import org.school.management.api.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceControllerImpl implements AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Override
    @GetMapping
    public HashMap<String, Object> findAll(Pageable pageable) throws Exception {
        return this.attendanceService.findAll(pageable);
    }

    @Override
    @GetMapping(value = "{id}")
    public AttendanceDto findById(Long id) throws Exception {
        return this.attendanceService.findById(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<AttendanceDto> create(AttendanceDto attendanceDto) throws Exception {
        return new ResponseEntity<>(this.attendanceService.create(attendanceDto), HttpStatus.CREATED);
    }

    @Override
    @PutMapping(value= "{id}")
    public ResponseEntity<AttendanceDto> edit(Long id, AttendanceDto attendanceDto) throws Exception {
        return new ResponseEntity<>(this.attendanceService.edit(id,attendanceDto), HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value= "{id}")
    public ResponseEntity<String> delete(Long id) throws Exception {
        return new ResponseEntity<>(this.attendanceService.delete(id), HttpStatus.OK);
    }
}
