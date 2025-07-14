package com.example.studentrecordsystem.dto;

public class GradeDetailsDTO {
    private Long studentId;
    private String studentName;
    private String email;
    private String courseName;
    private String courseCode;
    private String grade;

    public GradeDetailsDTO(Long studentId, String studentName, String email, String courseName, String courseCode, String grade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.grade = grade;
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

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}

