package org.school.management.api.seeder;

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

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
        roles.add(new Role(1L, UserRole.ROLE_USER));
        roles.add(new Role(2L, UserRole.ROLE_MODERATOR));
        roles.add(new Role(3L, UserRole.ROLE_ADMIN));
        roleRepository.saveAll(roles);
    }

    private List<Course> seedCourses() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1L,"Matematica","N/A","Primer año",null,null));
        courses.add(new Course(2L,"Fisica","N/A","Primer año",null,null));
        courses.add(new Course(3L,"Mecanica","N/A","Segundo año",null,null));
        courses.add(new Course(4L,"Automatizacion","N/A","Segundo año",null,null));
        return courseRepository.saveAll(courses);
    }

    private List<Teacher> seedTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher(1L,"Carles Solorzano","carles@gmail.com","+543764010101","M",30,"Posadas",null,null));
        teachers.add(new Teacher(2L,"Rubén Paz","ruben@gmail.com","+543764010101","M",27,"Posadas",null,null));
        teachers.add(new Teacher(3L,"Salvador de Jesús","salvador@gmail.com","+543764010101","M",35,"Posadas",null,null));
        teachers.add(new Teacher(4L,"Ángel Valdivia","angel@gmail.com","+543764010101","M",35,"Posadas",null,null));
        return teacherRepository.saveAll(teachers);
    }

    private List<Student> seedStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L,"Ovidio Téllez","ovidio@gmail.com","+543764010101","M",18,"Posadas",null,null));
        students.add(new Student(2L,"Gregorio Serrano","gregorio@gmail.com","+543764010101","M",20,"Posadas",null,null));
        students.add(new Student(3L,"Alex Moliner","alex@gmail.com","+543764010101","M",19,"Posadas",null,null));
        students.add(new Student(4L,"Marita Gárate","marita@gmail.com","+543764010101","M",17,"Posadas",null,null));
        return studentRepository.saveAll(students);
    }

    private void seedAttendances(List<Student> students, List<Teacher> teachers) {
        List<Attendance> attendances = new ArrayList<>();
        attendances.add(new Attendance(1L, LocalDate.of(2022, Month.JULY,21), new HashSet<>(students), new HashSet<>(teachers)));
        attendances.add(new Attendance(2L, LocalDate.of(2022, Month.JULY,23), new HashSet<>(students), new HashSet<>(teachers)));
        attendances.add(new Attendance(3L, LocalDate.of(2022, Month.JULY,27), new HashSet<>(students), new HashSet<>(teachers)));
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
