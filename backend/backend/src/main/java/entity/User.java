package entity;

import java.security.Timestamp;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
     String username;
     String phone;
     String email;
     String password;
     String full_name;
     String role;
     String status;
     String avatar_url;
     Timestamp created_at;
}
