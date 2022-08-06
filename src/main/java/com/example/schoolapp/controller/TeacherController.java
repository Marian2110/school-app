package com.example.schoolapp.controller;

import com.example.schoolapp.model.entity.Teacher;
import com.example.schoolapp.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @PostMapping
    public Teacher addTeacher(final Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable final String id) {
        teacherService.deleteTeacher(id);
    }
}
