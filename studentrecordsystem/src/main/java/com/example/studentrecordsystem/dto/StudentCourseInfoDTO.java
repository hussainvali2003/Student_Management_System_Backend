package com.example.studentrecordsystem.dto;

public class StudentCourseInfoDTO {
    private Long studentId;
    private String studentName;
    private String email;
    private Long courseId;
    private String courseName;
    private String courseCode;

    public StudentCourseInfoDTO(Long studentId, String studentName, String email,
                                 Long courseId, String courseName, String courseCode) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    // Getters and setters
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
}
