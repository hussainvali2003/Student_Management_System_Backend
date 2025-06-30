package com.example.studentrecordsystem.controller;

 
import org.springframework.web.bind.annotation.*;

import com.example.studentrecordsystem.dto.AttendanceDTO;
import com.example.studentrecordsystem.dto.AttendanceDetailsDTO;
import com.example.studentrecordsystem.services.AttendanceService;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "http://localhost:5173")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public List<AttendanceDTO> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @GetMapping("/{id}")
    public AttendanceDTO getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id);
    }

    @PostMapping
    public AttendanceDTO createAttendance(@RequestBody AttendanceDTO dto) {
        return attendanceService.createAttendance(dto);
    }

    @PutMapping("/{id}")
    public AttendanceDTO updateAttendance(@PathVariable Long id, @RequestBody AttendanceDTO dto) {
        return attendanceService.updateAttendance(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
    }
    
    @GetMapping("/details")
    public List<AttendanceDetailsDTO> getAttendanceDetails(@RequestParam Long studentId) {
        return attendanceService.getAttendanceDetails(studentId);
    }

}
