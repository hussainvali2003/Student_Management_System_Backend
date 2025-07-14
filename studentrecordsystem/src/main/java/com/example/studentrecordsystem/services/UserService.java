package com.example.studentrecordsystem.services;

import org.springframework.stereotype.Service;
import com.example.studentrecordsystem.dto.UserDTO;
import com.example.studentrecordsystem.models.User;
import com.example.studentrecordsystem.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO register(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword()); // Optional: hash this
        user.setRole(dto.getRole());

        user = userRepository.save(user);
        return new UserDTO(user.getId(), user.getUsername(), null, user.getRole());
    }

    public UserDTO login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid username or password");
        }
        return new UserDTO(user.getId(), user.getUsername(), null, user.getRole());
    }
}
