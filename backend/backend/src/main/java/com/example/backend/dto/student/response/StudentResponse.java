package com.example.backend.dto.student.response;

import com.example.backend.dto.user.response.UserResponse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse extends UserResponse {
    Date Date_of_birth;
}
