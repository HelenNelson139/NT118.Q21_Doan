package com.example.backend.dto.user.response;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String username;
    String password;
    String email;
    String phone;
    String full_name;
    String status;
}
