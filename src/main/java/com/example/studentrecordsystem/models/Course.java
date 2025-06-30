package com.example.studentrecordsystem.models;

 
import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseCode;
    private String courseName;
    private int credit;

    public Course() {}

    public Course(Long id, String courseCode, String courseName, int credit) {
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

