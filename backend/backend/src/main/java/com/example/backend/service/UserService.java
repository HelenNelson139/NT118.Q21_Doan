package com.example.backend.service;
import com.example.backend.dto.user.request.CreateUserRequest;
import com.example.backend.entity.User;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.backend.Mapper.UserMapper;
import com.example.backend.respository.UserResponsitory;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserResponsitory userResponsitory;

    public User createUser(CreateUserRequest createUserRequest){
        User user = userMapper.toCrete(createUserRequest);
        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        return user;
    }

    public List<User> findAllUser(){
        return userResponsitory.findAll();
    }

}
