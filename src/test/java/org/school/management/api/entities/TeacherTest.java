package org.school.management.api.entities;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TeacherTest {

  @DisplayName( "Debe eliminar al profesor el curso pasado como parametro,"
      + "y el curso debe quedar con profesor en nulo." )
  @Test
  void removeCourse() {
    Course course = Course.builder().id( 1L ).name( "Mechanics" ).build();
    Set<Course> courses = new HashSet<>(Set.of(course));

    Teacher teacher = Teacher.builder().id( 1L ).courses( courses ).build();
    course.setTeacher( teacher );

    teacher.removeCourse( course );

    assertTrue( teacher.getCourses().isEmpty(), "Se esperaba que 'Teacher' tenga la lista de cursos vacia.");
    assertNull( course.getTeacher(), "Se esperaba que 'Course' tenga un profesor nulo." );
  }

}