package com.example.backend.service;

import com.example.backend.Mapper.TeacherMapper;
import com.example.backend.Mapper.UserMapper;
import com.example.backend.dto.user.request.CreateUserRequest;
import com.example.backend.dto.teacher.request.TeacherCreationRequest;
import com.example.backend.entity.Teacher;
import com.example.backend.entity.User;
import com.example.backend.respository.TeacherResponsitory;
import com.example.backend.respository.UserResponsitory;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherService implements IUserService{

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserResponsitory userResponsitory;
    private final TeacherResponsitory teacherResponsitory;
    private final TeacherMapper teacherMapper;

    @Override
    @Transactional
    public void register(CreateUserRequest createUserRequest){
        User user = userMapper.toCreate(createUserRequest);
        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        userResponsitory.save(user);
      if(createUserRequest instanceof TeacherCreationRequest teacherCreationRequest){
          Teacher teacher = teacherMapper.toCreate(teacherCreationRequest);
          teacher.setUser(user);
          teacherResponsitory.save(teacher);
      }
    }
}
