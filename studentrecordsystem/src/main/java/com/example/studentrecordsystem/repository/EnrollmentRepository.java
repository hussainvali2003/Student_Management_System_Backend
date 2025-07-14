package com.example.studentrecordsystem.repository;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.studentrecordsystem.dto.StudentCourseInfoDTO;
import com.example.studentrecordsystem.models.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	List<Enrollment> findByStudentId(Long studentId);
	  @Query("SELECT new com.example.studentrecordsystem.dto.StudentCourseInfoDTO(" +
	           "s.id, CONCAT(s.firstName, ' ', s.lastName), s.email, " +
	           "c.id, c.courseName, c.courseCode) " +
	           "FROM Enrollment e " +
	           "JOIN e.student s " +
	           "JOIN e.course c " +
	           "WHERE s.id = :studentId")
	 List<StudentCourseInfoDTO> findStudentCourseInfoByStudentId(@Param("studentId") Long studentId);

}
