package com.example.backend.respository;

import com.example.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaAuditing
public interface StudentResponsitory extends JpaRepository<Student, Integer> {
}
