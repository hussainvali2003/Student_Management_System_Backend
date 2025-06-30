package com.example.studentrecordsystem.repository;

import com.example.studentrecordsystem.dto.GradeDetailsDTO;
import com.example.studentrecordsystem.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudentId(Long studentId);

    @Query("SELECT new com.example.studentrecordsystem.dto.GradeDetailsDTO(\n" +
           "g.student.id, CONCAT(g.student.firstName, ' ', g.student.lastName), g.student.email,\n" +
           "g.course.courseName, g.course.courseCode, g.grade)\n" +
           "FROM Grade g WHERE g.student.id = :studentId")
    List<GradeDetailsDTO> findDetailedGradesByStudentId(Long studentId);
}