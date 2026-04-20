package com.example.backend.dto.user.teacher.request;

import com.example.backend.dto.user.request.CreateUserRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class TeacherCreationRequest extends CreateUserRequest {
     String teacher_code;
     String department;
}
