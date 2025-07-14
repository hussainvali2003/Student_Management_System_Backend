package com.example.studentrecordsystem.services;

import com.example.studentrecordsystem.dto.FacultyDTO;
import com.example.studentrecordsystem.models.Faculty;
import com.example.studentrecordsystem.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public FacultyDTO createFaculty(FacultyDTO dto) {
        Faculty faculty = new Faculty();
        faculty.setFirstName(dto.getFirstName());
        faculty.setLastName(dto.getLastName());
        faculty.setEmail(dto.getEmail());
        faculty.setPassword(dto.getPassword());
        faculty.setDepartment(dto.getDepartment());
        faculty.setRole("FACULTY");
        Faculty saved = facultyRepository.save(faculty);

        return mapToDTO(saved);
    }

    public List<FacultyDTO> getAllFaculties() {
        return facultyRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public FacultyDTO login(String email, String password) {
        Faculty faculty = facultyRepository.findByEmail(email);
        if (faculty == null || !faculty.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }
        return mapToDTO(faculty);
    }

    private FacultyDTO mapToDTO(Faculty faculty) {
        return new FacultyDTO(
            faculty.getId(),
            faculty.getFirstName(),
            faculty.getLastName(),
            faculty.getEmail(),
            faculty.getPassword(),
            faculty.getDepartment(),
            "FACULTY" // ✅ Explicitly hardcoded role
        );
    }

}
