package com.example.TestProject.controller;

import com.example.TestProject.model.User;
import com.example.TestProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/testProject")

public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        userRepository.save(user);
        return "Saved user: " + name;
    }

    @GetMapping(path = "/all")
    public  @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
