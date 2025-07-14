package com.example.studentrecordsystem.dto;

 
public class CourseDTO {

    private Long id;
    private String courseCode;
    private String courseName;
    private int credit;

    public CourseDTO() {}

    public CourseDTO(Long id, String courseCode, String courseName, int credit) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credit = credit;
    }

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public int getCredit() { return credit; }
    public void setCredit(int credit) { this.credit = credit; }
}
