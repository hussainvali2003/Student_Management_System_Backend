package com.example.studentrecordsystem.dto;
 
import java.time.LocalDate;

public class EnrollmentDTO {

    private Long id;
    private String semester;
    private LocalDate enrollmentDate;
    private Long studentId;
    private Long courseId;

    public EnrollmentDTO() {}

    public EnrollmentDTO(Long id, String semester, LocalDate enrollmentDate, Long studentId, Long courseId) {
        this.id = id;
        this.semester = semester;
        this.enrollmentDate = enrollmentDate;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }
}
