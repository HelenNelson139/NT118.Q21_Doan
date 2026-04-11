package entity;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String username;
    private String phone;
    private String email;
    private String password;
    private String full_name;
    private String role;
    private String status;
    private String avatar_url;
    private Timestamp created_at;
}
