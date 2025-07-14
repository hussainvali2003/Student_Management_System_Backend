package com.example.studentrecordsystem.services;

 
 

import org.springframework.stereotype.Service;

import com.example.studentrecordsystem.dto.AttendanceDTO;
import com.example.studentrecordsystem.dto.AttendanceDetailsDTO;
import com.example.studentrecordsystem.models.Attendance;
import com.example.studentrecordsystem.models.Course;
import com.example.studentrecordsystem.models.Student;
import com.example.studentrecordsystem.repository.AttendanceRepository;
import com.example.studentrecordsystem.repository.CourseRepository;
import com.example.studentrecordsystem.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public AttendanceService(AttendanceRepository attendanceRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public List<AttendanceDetailsDTO> getAttendanceDetails(Long studentId) {
        return attendanceRepository.getAttendanceDetailsByStudentId(studentId);
    }

    public List<AttendanceDTO> getAllAttendance() {
        return attendanceRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AttendanceDTO getAttendanceById(Long id) {
        Attendance attendance = attendanceRepository.findById(id).orElse(null);
        return (attendance != null) ? convertToDTO(attendance) : null;
    }

    public AttendanceDTO createAttendance(AttendanceDTO dto) {
        Attendance attendance = convertToEntity(dto);
        attendance = attendanceRepository.save(attendance);
        return convertToDTO(attendance);
    }

    public AttendanceDTO updateAttendance(Long id, AttendanceDTO dto) {
        Attendance attendance = attendanceRepository.findById(id).orElse(null);
        if (attendance == null) return null;

        attendance.setDate(dto.getDate());
        attendance.setStatus(dto.getStatus());

        Student student = studentRepository.findById(dto.getStudentId()).orElse(null);
        Course course = courseRepository.findById(dto.getCourseId()).orElse(null);

        attendance.setStudent(student);
        attendance.setCourse(course);

        attendance = attendanceRepository.save(attendance);
        return convertToDTO(attendance);
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    private AttendanceDTO convertToDTO(Attendance a) {
        return new AttendanceDTO(a.getId(), a.getDate(), a.getStatus(),
                a.getStudent() != null ? a.getStudent().getId() : null,
                a.getCourse() != null ? a.getCourse().getId() : null);
    }

    private Attendance convertToEntity(AttendanceDTO dto) {
        Student student = studentRepository.findById(dto.getStudentId()).orElse(null);
        Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
        return new Attendance(dto.getId(), dto.getDate(), dto.getStatus(), student, course);
    }
}

