package org.school.management.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serial;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "students")
public class Student extends Person {

    @Serial
    private static final long serialVersionUID = -7448720652766367341L;

    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    private Set<Attendance> attendances = new HashSet<>();

    public void addCourse(Course course) {
        this.courses.add(course);
        course.getStudents().add(this);
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
        course.getStudents().remove(this);
    }
}
