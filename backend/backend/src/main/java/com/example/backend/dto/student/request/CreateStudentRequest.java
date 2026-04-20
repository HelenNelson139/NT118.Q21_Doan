package com.example.backend.dto.student.request;

import com.example.backend.dto.user.request.CreateUserRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateStudentRequest extends CreateUserRequest {
    String student_code;
    String date_of_birth;
}
