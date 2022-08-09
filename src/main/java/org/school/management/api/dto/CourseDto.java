package org.school.management.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseDto {

    private Long id;

    private String name;

    private String description;

    private String level;

    private LocalDateTime createdDate;

    private Set<CourseRegistrationDto> registrations;
}
