package com.example.backend.controller;

import com.example.backend.dto.user.request.CreateUserRequest;
import com.example.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @PostMapping
    public void createTeacher(@RequestBody CreateUserRequest createUserRequest){
        teacherService.register(createUserRequest);

    }
}
