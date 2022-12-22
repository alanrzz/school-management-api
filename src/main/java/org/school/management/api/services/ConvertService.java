package org.school.management.api.services;

import org.school.management.api.dto.AttendanceDto;
import org.school.management.api.dto.CourseDto;
import org.school.management.api.dto.StudentDto;
import org.school.management.api.dto.TeacherDto;
import org.school.management.api.dto.UserDto;
import org.school.management.api.entities.Attendance;
import org.school.management.api.entities.Course;
import org.school.management.api.entities.Student;
import org.school.management.api.entities.Teacher;
import org.school.management.api.entities.User;
import org.springframework.data.domain.Page;

import java.util.HashMap;

public interface ConvertService {

    Student convertToEntity(StudentDto studentDto);

    StudentDto convertToDto(Student student);

    Teacher convertToEntity(TeacherDto teacherDto);

    TeacherDto convertToDto(Teacher teacher);

    Course convertToEntity(CourseDto courseDto);

    CourseDto convertToDto(Course course);

    Attendance convertToEntity(AttendanceDto attendanceDto);

    AttendanceDto convertToDto(Attendance attendance);

    User convertToEntity(UserDto userDto);

    UserDto convertToDto(User user);

    HashMap<String, Object> convertToStudentFormat(Page<Student> students);

    HashMap<String, Object> convertToTeacherFormat(Page<Teacher> teachers);

    HashMap<String, Object> convertToCourseFormat(Page<Course> courses);

    HashMap<String, Object> convertToAttendanceFormat(Page<Attendance> attendances);
}