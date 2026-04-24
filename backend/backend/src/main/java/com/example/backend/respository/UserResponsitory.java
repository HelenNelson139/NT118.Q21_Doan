package com.example.backend.respository;

import com.example.backend.entity.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaAuditing
public interface UserResponsitory extends JpaRepository<User, Integer> {
    public User findByUsername(String username);
    public User findByEmail(String email);
    public User findByPhone(String phone);

}
