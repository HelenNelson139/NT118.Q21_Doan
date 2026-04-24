package com.example.backend.service;

import com.example.backend.Mapper.StudentMapper;
import com.example.backend.Mapper.UserMapper;
import com.example.backend.dto.student.request.CreateStudentRequest;
import com.example.backend.dto.user.request.CreateUserRequest;
import com.example.backend.entity.Student;
import com.example.backend.entity.User;
import com.example.backend.respository.StudentResponsitory;
import com.example.backend.respository.UserResponsitory;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService implements IUserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserResponsitory userResponsitory;
    private final StudentResponsitory studentResponsitory;
    private final StudentMapper studentMapper;
    private final UserService userService;

    @Override
    @Transactional
    public void register(CreateUserRequest createUserRequest){
        if(userService.checkUserExist(createUserRequest)){
            User user = userMapper.toCreate(createUserRequest);
            user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
            userResponsitory.save(user);
            if(createUserRequest instanceof CreateStudentRequest createStudentRequest){
                Student student = studentMapper.toCreate(createStudentRequest);
                student.setUser(user);
                studentResponsitory.save(student);
            }
        }

    }
}
