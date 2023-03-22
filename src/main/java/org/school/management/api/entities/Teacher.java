package org.school.management.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serial;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "teachers")
public class Teacher extends Person {

    @Serial
    private static final long serialVersionUID = -6988466030224859582L;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "teachers")
    private Set<Attendance> attendances = new HashSet<>();

    public void removeCourse(Course course){
        this.courses.remove(course);
        course.setTeacher(null);
    }
}
