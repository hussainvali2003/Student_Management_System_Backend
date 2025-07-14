package com.example.studentrecordsystem.controller;

 
 
import org.springframework.web.bind.annotation.*;

import com.example.studentrecordsystem.dto.UserDTO;
import com.example.studentrecordsystem.services.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDTO register(@RequestBody UserDTO dto) {
        return userService.register(dto);
    }
     
    @PostMapping("/login")
    public UserDTO login(@RequestBody UserDTO dto) {
        return userService.login(dto.getUsername(), dto.getPassword());
    }
}

