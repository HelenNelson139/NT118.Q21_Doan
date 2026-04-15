package com.example.backend.controller;

import com.example.backend.dto.user.request.CreateUserRequest;
import com.example.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend.respository.UserResponsitory;
import com.example.backend.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserResponsitory userResponsitory;
    @PostMapping

    public User createUser(@RequestBody CreateUserRequest createUserRequest){
        return userService.createUser(createUserRequest);
    }

}
