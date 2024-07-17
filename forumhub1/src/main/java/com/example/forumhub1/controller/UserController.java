package com.example.forumhub1.controller;

import com.example.forumhub1.model.User;
import com.example.forumhub1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository; // Supondo que você tenha um UserRepository

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

