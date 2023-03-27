package com.rest.api.controller;

import com.rest.api.User;
import com.rest.api.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public @ResponseBody Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("{userID}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Optional<User> findUserByID(@PathVariable UUID userID) {
        return userRepository.findById(userID);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Map<String, String> addNewUser (@RequestBody User user) {
        userRepository.save(user);
        return Map.of("message", "success");
    }
}
