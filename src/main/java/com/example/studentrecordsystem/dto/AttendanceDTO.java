package com.example.studentrecordsystem.dto;

 
import java.time.LocalDate;

public class AttendanceDTO {

    private Long id;
    private LocalDate date;
    private String status;
    private Long studentId;
    private Long courseId;

    public AttendanceDTO() {}

    public AttendanceDTO(Long id, LocalDate date, String status, Long studentId, Long courseId) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }
}
