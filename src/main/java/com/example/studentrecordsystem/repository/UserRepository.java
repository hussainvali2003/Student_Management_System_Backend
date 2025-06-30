package com.example.studentrecordsystem.repository;

 
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentrecordsystem.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
