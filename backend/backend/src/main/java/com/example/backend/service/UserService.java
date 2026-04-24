package com.example.backend.service;


import com.example.backend.dto.user.request.CreateUserRequest;
import com.example.backend.respository.UserResponsitory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor //cần phải khởi tạo biến private final liền sau đó không thay đổi biến này nữa nên dùng
public class UserService {
    private final UserResponsitory userResponsitory;

    public boolean checkUserExist(CreateUserRequest createUserRequest) {
        if (userResponsitory.findByUsername(createUserRequest.getUsername()) != null) {
            throw new RuntimeException("User already exist");
        }else if (userResponsitory.findByEmail(createUserRequest.getEmail()) != null) {
            throw new RuntimeException("Email already exist");
        }else if (userResponsitory.findByPhone(createUserRequest.getPhone()) != null) {
            throw new RuntimeException("Phone already exist");
        }else{
            return true;
        }
    }
}
