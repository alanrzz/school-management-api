package org.school.management.api.repositories;

import org.school.management.api.entities.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long>, JpaSpecificationExecutor<CourseRegistration> {
}