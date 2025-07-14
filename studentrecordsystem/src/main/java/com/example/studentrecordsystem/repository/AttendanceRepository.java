package com.example.studentrecordsystem.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.studentrecordsystem.dto.AttendanceDetailsDTO;
import com.example.studentrecordsystem.models.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	List<Attendance> findByStudentId(Long studentId);
	@Query("SELECT new com.example.studentrecordsystem.dto.AttendanceDetailsDTO(" +
		       "a.student.id, CONCAT(a.student.firstName, ' ', a.student.lastName), a.student.email, " +
		       "a.course.courseName, a.course.courseCode, a.date, a.status) " +
		       "FROM Attendance a WHERE a.student.id = :studentId")
		List<AttendanceDetailsDTO> getAttendanceDetailsByStudentId(Long studentId);

 
}
 