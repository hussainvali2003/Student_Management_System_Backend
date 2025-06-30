package com.example.studentrecordsystem.controller;
 
import org.springframework.web.bind.annotation.*;

import com.example.studentrecordsystem.dto.EnrollmentDTO;
import com.example.studentrecordsystem.services.EnrollmentService;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "http://localhost:5173")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public List<EnrollmentDTO> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public EnrollmentDTO getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id);
    }

    @PostMapping
    public EnrollmentDTO createEnrollment(@RequestBody EnrollmentDTO dto) {
        return enrollmentService.createEnrollment(dto);
    }

    @PutMapping("/{id}")
    public EnrollmentDTO updateEnrollment(@PathVariable Long id, @RequestBody EnrollmentDTO dto) {
        return enrollmentService.updateEnrollment(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
    }
}
