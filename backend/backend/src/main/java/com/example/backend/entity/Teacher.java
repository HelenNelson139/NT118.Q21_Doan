package com.example.backend.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "teachers")
public class Teacher {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     String id;
     @OneToOne
     @MapsId
     @JoinColumn(name = "user_id")
     private User user;
     String teacher_code;
     String department;
}
