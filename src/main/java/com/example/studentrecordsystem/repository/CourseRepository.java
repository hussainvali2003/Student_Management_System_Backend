package com.example.studentrecordsystem.repository;
  
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentrecordsystem.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
