package com.klu.controller;

import com.klu.dto.LoginRequest;
import com.klu.entity.AppUser;
import com.klu.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository repo;

    public AuthController(UserRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/login-db")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        AppUser user = repo.findByUsername(request.getUsername())
                           .orElse(null);

        if (user != null &&
            user.getPassword().equals(request.getPassword())) {

            return ResponseEntity.ok("Authentication Successful");
        }

        return ResponseEntity.status(401)
                .body("Authentication Failed");
    }
}