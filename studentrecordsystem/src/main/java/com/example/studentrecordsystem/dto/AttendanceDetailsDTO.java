package com.example.studentrecordsystem.dto;

import java.time.LocalDate;

public class AttendanceDetailsDTO {
    private Long studentId;
    private String studentName;
    private String email;
    private String courseName;
    private String courseCode;
    private LocalDate date;
    private String status;

    public AttendanceDetailsDTO(Long studentId, String studentName, String email,
                                 String courseName, String courseCode,
                                 LocalDate date, String status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.date = date;
        this.status = status;
    }

    // Getters and Setters
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
