package com.example.schoolapp.service;

import com.example.schoolapp.model.entity.Teacher;
import com.example.schoolapp.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final UserService userService;

    public Teacher addTeacher(Teacher teacher) {
        Teacher addedTeacher = teacherRepository.save(teacher);
        userService.addUser(addedTeacher.id());
        return addedTeacher;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void deleteTeacher(String id) {
        teacherRepository.deleteById(id);
    }

    public Optional<Teacher> findByName(String username) {
        return teacherRepository.findByName(username);
    }
}
