package com.example.studentrecordsystem.repository;

import com.example.studentrecordsystem.models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByEmail(String email);
}
