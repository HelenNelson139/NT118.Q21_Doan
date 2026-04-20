package com.example.backend.service;


import com.example.backend.dto.user.request.CreateUserRequest;
import com.example.backend.dto.user.response.UserResponse;

public interface IUserService {
    void register(CreateUserRequest createUserRequest);
}
