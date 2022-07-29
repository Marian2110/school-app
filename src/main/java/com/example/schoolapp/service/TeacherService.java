package com.example.schoolapp.service;

import com.example.schoolapp.model.entity.Teacher;
import com.example.schoolapp.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
