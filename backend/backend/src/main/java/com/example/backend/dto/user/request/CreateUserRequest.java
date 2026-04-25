package com.example.backend.dto.user.request;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserRequest {
    String username;
    String phone;
    String email;
    String password;
    String full_name;
    String role;
    String status;
    String avatar_url;
}
