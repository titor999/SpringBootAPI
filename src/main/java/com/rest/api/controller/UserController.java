package com.rest.api.controller;

import com.rest.api.User;
import com.rest.api.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("user/{userID}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> findUserByID(@PathVariable UUID userID) {
        return userRepository.findById(userID);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public Long addNewUser(@RequestBody User user) {
        userRepository.save(user);
        return user.getId();
    }
}
