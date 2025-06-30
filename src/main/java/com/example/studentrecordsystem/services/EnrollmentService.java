package com.example.studentrecordsystem.services;

 

import org.springframework.stereotype.Service;

import com.example.studentrecordsystem.dto.EnrollmentDTO;
import com.example.studentrecordsystem.models.Course;
import com.example.studentrecordsystem.models.Enrollment;
import com.example.studentrecordsystem.models.Student;
import com.example.studentrecordsystem.repository.CourseRepository;
import com.example.studentrecordsystem.repository.EnrollmentRepository;
import com.example.studentrecordsystem.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public List<EnrollmentDTO> getAllEnrollments() {
        return enrollmentRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public EnrollmentDTO getEnrollmentById(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElse(null);
        return (enrollment != null) ? convertToDTO(enrollment) : null;
    }

    public EnrollmentDTO createEnrollment(EnrollmentDTO dto) {
        Enrollment enrollment = convertToEntity(dto);
        enrollment = enrollmentRepository.save(enrollment);
        return convertToDTO(enrollment);
    }

    public EnrollmentDTO updateEnrollment(Long id, EnrollmentDTO dto) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElse(null);
        if (enrollment == null) return null;

        enrollment.setSemester(dto.getSemester());
        enrollment.setEnrollmentDate(dto.getEnrollmentDate());
        enrollment.setStudent(studentRepository.findById(dto.getStudentId()).orElse(null));
        enrollment.setCourse(courseRepository.findById(dto.getCourseId()).orElse(null));

        enrollment = enrollmentRepository.save(enrollment);
        return convertToDTO(enrollment);
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }

    private EnrollmentDTO convertToDTO(Enrollment e) {
        return new EnrollmentDTO(
            e.getId(),
            e.getSemester(),
            e.getEnrollmentDate(),
            e.getStudent() != null ? e.getStudent().getId() : null,
            e.getCourse() != null ? e.getCourse().getId() : null
        );
    }

    private Enrollment convertToEntity(EnrollmentDTO dto) {
        Student student = studentRepository.findById(dto.getStudentId()).orElse(null);
        Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
        return new Enrollment(dto.getId(), dto.getSemester(), dto.getEnrollmentDate(), student, course);
    }
}
