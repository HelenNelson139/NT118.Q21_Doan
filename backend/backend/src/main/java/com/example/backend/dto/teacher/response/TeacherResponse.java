package com.example.backend.dto.teacher.response;

import com.example.backend.dto.user.response.UserResponse;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class TeacherResponse extends UserResponse {
    String department;
}
