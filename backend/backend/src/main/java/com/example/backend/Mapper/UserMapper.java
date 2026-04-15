package com.example.backend.Mapper;

import com.example.backend.dto.user.request.CreateUserRequest;
import com.example.backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password", ignore = true)
    User toCrete(CreateUserRequest createUserRequest);
}
