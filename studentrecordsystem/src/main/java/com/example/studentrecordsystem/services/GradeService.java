package com.example.studentrecordsystem.services;
 

import org.springframework.stereotype.Service;

import com.example.studentrecordsystem.dto.GradeDTO;
import com.example.studentrecordsystem.dto.GradeDetailsDTO;
import com.example.studentrecordsystem.models.Course;
import com.example.studentrecordsystem.models.Grade;
import com.example.studentrecordsystem.models.Student;
import com.example.studentrecordsystem.repository.CourseRepository;
import com.example.studentrecordsystem.repository.GradeRepository;
import com.example.studentrecordsystem.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public GradeService(GradeRepository gradeRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public List<GradeDTO> getAllGrades() {
        return gradeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public GradeDTO getGradeById(Long id) {
        Grade grade = gradeRepository.findById(id).orElse(null);
        return (grade != null) ? convertToDTO(grade) : null;
    }

    public GradeDTO createGrade(GradeDTO dto) {
        Grade grade = convertToEntity(dto);
        grade = gradeRepository.save(grade);
        return convertToDTO(grade);
    }

    public GradeDTO updateGrade(Long id, GradeDTO dto) {
        Grade grade = gradeRepository.findById(id).orElse(null);
        if (grade == null) return null;

        grade.setGrade(dto.getGrade());
        grade.setStudent(studentRepository.findById(dto.getStudentId()).orElse(null));
        grade.setCourse(courseRepository.findById(dto.getCourseId()).orElse(null));

        grade = gradeRepository.save(grade);
        return convertToDTO(grade);
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }

    private GradeDTO convertToDTO(Grade grade) {
        return new GradeDTO(
            grade.getId(),
            grade.getGrade(),
            grade.getStudent() != null ? grade.getStudent().getId() : null,
            grade.getCourse() != null ? grade.getCourse().getId() : null
        );
    }

    private Grade convertToEntity(GradeDTO dto) {
        Student student = studentRepository.findById(dto.getStudentId()).orElse(null);
        Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
        return new Grade(dto.getId(), dto.getGrade(), student, course);
    }
    public List<GradeDetailsDTO> getDetailedGradesForStudent(Long studentId) {
        return gradeRepository.findDetailedGradesByStudentId(studentId);
    }
}
