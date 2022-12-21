package org.school.management.api.services.impl;

import org.modelmapper.ModelMapper;
import org.school.management.api.dto.AttendanceDto;
import org.school.management.api.dto.CourseDto;
import org.school.management.api.dto.StudentDto;
import org.school.management.api.dto.TeacherDto;
import org.school.management.api.entities.Attendance;
import org.school.management.api.entities.Course;
import org.school.management.api.entities.Student;
import org.school.management.api.entities.Teacher;
import org.school.management.api.repositories.AttendanceRepository;
import org.school.management.api.repositories.CourseRepository;
import org.school.management.api.repositories.StudentRepository;
import org.school.management.api.repositories.TeacherRepository;
import org.school.management.api.services.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ConvertServiceImpl implements ConvertService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    @Override
    public Student convertToEntity(StudentDto studentDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(studentDto, Student.class);
    }

    @Override
    public StudentDto convertToDto(Student student) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public Teacher convertToEntity(TeacherDto teacherDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(teacherDto, Teacher.class);
    }

    @Override
    public TeacherDto convertToDto(Teacher teacher) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(teacher, TeacherDto.class);
    }

    @Override
    public Course convertToEntity(CourseDto courseDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(courseDto, Course.class);
    }

    @Override
    public CourseDto convertToDto(Course course) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(course, CourseDto.class);
    }

    @Override
    public Attendance convertToEntity(AttendanceDto attendanceDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(attendanceDto, Attendance.class);
    }

    @Override
    public AttendanceDto convertToDto(Attendance attendance) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(attendance, AttendanceDto.class);
    }

    @Override
    public HashMap<String, Object> convertToStudentFormat(Page<Student> students) {
        HashMap<String, Object> studentFormat = new HashMap<>();
        studentFormat.put("meta", this.generateMeta(studentRepository.count(),students));
        studentFormat.put("data", students.getContent().stream().map(this::convertToDto));
        return studentFormat;
    }

    @Override
    public HashMap<String, Object> convertToTeacherFormat(Page<Teacher> teachers) {
        HashMap<String, Object> teacherFormat = new HashMap<>();
        teacherFormat.put("meta", this.generateMeta(teacherRepository.count(),teachers));
        teacherFormat.put("data", teachers.getContent().stream().map(this::convertToDto));
        return teacherFormat;
    }

    @Override
    public HashMap<String, Object> convertToCourseFormat(Page<Course> courses) {
        HashMap<String, Object> teacherFormat = new HashMap<>();
        teacherFormat.put("meta", this.generateMeta(courseRepository.count(),courses));
        teacherFormat.put("data", courses.getContent().stream().map(this::convertToDto));
        return teacherFormat;
    }

    @Override
    public HashMap<String, Object> convertToAttendanceFormat(Page<Attendance> attendances) {
        HashMap<String, Object> attendanceFormat = new HashMap<>();
        attendanceFormat.put("meta", this.generateMeta(attendanceRepository.count(),attendances));
        attendanceFormat.put("data", attendances.getContent().stream().map(this::convertToDto));
        return attendanceFormat;
    }

    private HashMap<String, Object> generateMeta(Long records, Page<?> page) {
        HashMap<String, Object> meta = new HashMap<>();
        meta.put("totalRecords", records);
        meta.put("filteredCount", page.getTotalElements());
        meta.put("pageNumber", page.getNumber());
        meta.put("pageSize", page.getSize());
        return meta;
    }
}
