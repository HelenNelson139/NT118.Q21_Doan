package com.example.backend.Mapper;


import com.example.backend.dto.teacher.request.TeacherCreationRequest;
import com.example.backend.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    @Mapping(target = "id", ignore = true)
    Teacher toCreate(TeacherCreationRequest teacherCreationRequest);
}
