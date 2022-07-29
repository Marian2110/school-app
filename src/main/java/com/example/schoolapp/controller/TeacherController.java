package com.example.schoolapp.controller;

import com.example.schoolapp.model.entity.Teacher;
import com.example.schoolapp.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public Teacher addTeacher(final Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }
}
