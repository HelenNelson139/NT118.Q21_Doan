package com.example.backend.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "students")
public class Student {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     String id;
     @OneToOne
     @MapsId
     @JoinColumn(name = "user_id")
     private User user;
     String student_code;
     Date date_of_birth;
}
