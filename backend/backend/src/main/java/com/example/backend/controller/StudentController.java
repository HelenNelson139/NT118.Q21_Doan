package com.example.backend.controller;

import com.example.backend.dto.ApiResponse;
import com.example.backend.dto.student.request.CreateStudentRequest;
import com.example.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/register")
    public ApiResponse<String> registerStudent(@RequestBody CreateStudentRequest createStudentRequest){
        studentService.register(createStudentRequest);
        return ApiResponse.<String>builder()
                .code(1000)
                .message("Đăng ký giáo viên thành công")
                .result("Dữ liệu đã được lưu cho mã: " + createStudentRequest.getStudent_code())
                .build();
    }

}
