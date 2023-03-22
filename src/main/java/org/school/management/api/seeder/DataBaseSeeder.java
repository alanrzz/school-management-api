package org.school.management.api.seeder;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.school.management.api.entities.Attendance;
import org.school.management.api.entities.Course;
import org.school.management.api.entities.Role;
import org.school.management.api.entities.Student;
import org.school.management.api.entities.Teacher;
import org.school.management.api.enums.UserRole;
import org.school.management.api.repositories.AttendanceRepository;
import org.school.management.api.repositories.CourseRepository;
import org.school.management.api.repositories.RoleRepository;
import org.school.management.api.repositories.StudentRepository;
import org.school.management.api.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataBaseSeeder {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedRoles();
        seedRelationships();
    }

    private void seedRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.builder().name(UserRole.ROLE_USER).build());
        roles.add(Role.builder().name(UserRole.ROLE_MODERATOR).build());
        roles.add(Role.builder().name(UserRole.ROLE_ADMIN).build());
        roleRepository.saveAll(roles);
    }

    private List<Course> seedCourses() {
        List<Course> courses = new ArrayList<>();
        courses.add(Course.builder().name("Matematica").description("N/A").level("Primer año").build());
        courses.add(Course.builder().name("Fisica").description("N/A").level("Primer año").build());
        courses.add(Course.builder().name("Mecanica").description("N/A").level("Segundo año").build());
        courses.add(Course.builder().name("Automatizacion").description("N/A").level("Segundo año").build());
        return courseRepository.saveAll(courses);
    }

    private List<Teacher> seedTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(Teacher.builder().name("Carles Solorzano")
            .email("carles@gmail.com").phone("+543764010101").gender("M").age(30).address("Posadas").build());
        teachers.add(Teacher.builder().name("Rubén Paz")
            .email("ruben@gmail.com").phone("+543764010101").gender("M").age(27).address("Posadas").build());
        teachers.add(Teacher.builder().name("Salvador de Jesús")
            .email("salvador@gmail.com").phone("+543764010101").gender("M").age(35).address("Posadas").build());
        teachers.add(Teacher.builder().name("Ángel Valdivia")
            .email("angel@gmail.com").phone("+543764010101").gender("M").age(35).address("Posadas").build());
        return teacherRepository.saveAll(teachers);
    }

    private List<Student> seedStudents() {
        List<Student> students = new ArrayList<>();
        students.add(Student.builder().name("Ovidio Téllez")
            .email("ovidio@gmail.com").phone("+543764010101").gender("M").age(18).address("Posadas").build());
        students.add(Student.builder().name("Gregorio Serrano")
            .email("gregorio@gmail.com").phone("+543764010101").gender("M").age(20).address("Posadas").build());
        students.add(Student.builder().name("Alex Moliner")
            .email("alex@gmail.com").phone("+543764010101").gender("M").age(19).address("Posadas").build());
        students.add(Student.builder().name("Marita Gárate")
            .email("marita@gmail.com").phone("+543764010101").gender("F").age(17).address("Posadas").build());
        return studentRepository.saveAll(students);
    }

    private void seedAttendances(List<Student> students, List<Teacher> teachers) {
        List<Attendance> attendances = new ArrayList<>();
        attendances.add(Attendance.builder().attendanceDate(LocalDate.of(2022, Month.JULY,21))
            .students(new HashSet<>(students)).teachers(new HashSet<>(teachers)).build());
        attendances.add(Attendance.builder().attendanceDate(LocalDate.of(2022, Month.JULY,23))
            .students(new HashSet<>(students)).teachers(new HashSet<>(teachers)).build());
        attendances.add(Attendance.builder().attendanceDate(LocalDate.of(2022, Month.JULY,27))
            .students(new HashSet<>(students)).teachers(new HashSet<>(teachers)).build());
        attendanceRepository.saveAll(attendances);
    }

    private void seedRelationships() {
        List<Course> courses = seedCourses();
        List<Teacher> teachers = seedTeachers();
        List<Student> students = seedStudents();
        seedAttendances(students,teachers);
        for(int i = 0; i < courses.size(); i++){
            Course course = courses.get(i);
            course.setTeacher(teachers.get(i));
            course.setStudents(new HashSet<>(students));
        }
        courseRepository.saveAll(courses);
    }
}
