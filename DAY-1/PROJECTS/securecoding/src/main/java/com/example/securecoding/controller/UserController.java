package com.example.securecoding.controller;
import com.example.securecoding.model.User;
import com.example.securecoding.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    private static final Logger logger =
            LoggerFactory.getLogger(UserController.class);

    public UserController(UserService service){

        this.service = service;

    }

    @GetMapping
    public Collection<User> getUsers(){

        logger.info("Fetching all users");

        return service.getAllUsers();

    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user){

        logger.info("Creating user with email: {}",user.getEmail());

        return service.addUser(user);

    }

}
