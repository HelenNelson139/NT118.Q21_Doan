package com.example.backend.Mapper;

import com.example.backend.dto.student.request.CreateStudentRequest;
import com.example.backend.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "id", ignore = true)
    Student toCreate(CreateStudentRequest createStudentRequest);

}
