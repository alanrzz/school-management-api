package org.school.management.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AttendanceDto {

    private Long id;

    private LocalDate attendanceDate;

    private Set<StudentDto> students = new HashSet<>();

    private Set<TeacherDto> teachers = new HashSet<>();
}
