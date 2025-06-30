package com.example.studentrecordsystem.services;
 
import org.springframework.stereotype.Service;

import com.example.studentrecordsystem.dto.CourseDTO;
import com.example.studentrecordsystem.models.Course;
import com.example.studentrecordsystem.repository.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        return (course != null) ? convertToDTO(course) : null;
    }

    public CourseDTO createCourse(CourseDTO dto) {
        Course course = convertToEntity(dto);
        course = courseRepository.save(course);
        return convertToDTO(course);
    }

    public CourseDTO updateCourse(Long id, CourseDTO dto) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) return null;

        course.setCourseCode(dto.getCourseCode());
        course.setCourseName(dto.getCourseName());
        course.setCredit(dto.getCredit());

        course = courseRepository.save(course);
        return convertToDTO(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    private CourseDTO convertToDTO(Course course) {
        return new CourseDTO(course.getId(), course.getCourseCode(), course.getCourseName(), course.getCredit());
    }

    private Course convertToEntity(CourseDTO dto) {
        return new Course(dto.getId(), dto.getCourseCode(), dto.getCourseName(), dto.getCredit());
    }
}
