package com.example.studentrecordsystem.dto;

 
public class GradeDTO {

    private Long id;
    private String grade;
    private Long studentId;
    private Long courseId;

    public GradeDTO() {}

    public GradeDTO(Long id, String grade, Long studentId, Long courseId) {
        this.id = id;
        this.grade = grade;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }
}
