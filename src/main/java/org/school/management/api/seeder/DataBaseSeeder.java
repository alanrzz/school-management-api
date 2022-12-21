package org.school.management.api.seeder;

import org.school.management.api.entities.Course;
import org.school.management.api.entities.Role;
import org.school.management.api.entities.Student;
import org.school.management.api.entities.Teacher;
import org.school.management.api.enums.UserRole;
import org.school.management.api.repositories.CourseRepository;
import org.school.management.api.repositories.RoleRepository;
import org.school.management.api.repositories.StudentRepository;
import org.school.management.api.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedRoles();
        seedCourses();
        seedTeachers();
        seedStudents();
    }

    private void seedRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1L, UserRole.ROLE_USER));
        roles.add(new Role(2L, UserRole.ROLE_MODERATOR));
        roles.add(new Role(3L, UserRole.ROLE_ADMIN));
        roleRepository.saveAll(roles);
    }

    private void seedCourses() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1L,"Matematica","N/A","Primer año",null,null));
        courses.add(new Course(2L,"Fisica","N/A","Primer año",null,null));
        courses.add(new Course(3L,"Mecanica","N/A","Segundo año",null,null));
        courses.add(new Course(4L,"Automatizacion","N/A","Segundo año",null,null));
        courseRepository.saveAll(courses);
    }

    private void seedTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher(1L,"Juan Diaz","juan@gmail.com","+543764010101","M",30,"Posadas",null,null));
        teachers.add(new Teacher(2L,"Miguel Gimenez","miguel@gmail.com","+543764010101","M",27,"Posadas",null,null));
        teachers.add(new Teacher(3L,"Santiago Lopez","santiago@gmail.com","+543764010101","M",35,"Posadas",null,null));
        teachers.add(new Teacher(4L,"Enrique Rodriguez","enrique@gmail.com","+543764010101","M",35,"Posadas",null,null));
        teacherRepository.saveAll(teachers);
    }

    private void seedStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L,"Ovidio Téllez","ovidio@gmail.com","+543764010101","M",18,"Posadas",null,null));
        students.add(new Student(2L,"Gregorio Serrano","gregorio@gmail.com","+543764010101","M",20,"Posadas",null,null));
        students.add(new Student(3L,"Alex Moliner","alex@gmail.com","+543764010101","M",19,"Posadas",null,null));
        students.add(new Student(4L,"Marita Gárate","marita@gmail.com","+543764010101","M",17,"Posadas",null,null));
        studentRepository.saveAll(students);
    }
}
