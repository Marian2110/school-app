package com.example.schoolapp.service;

import com.example.schoolapp.model.entity.Student;
import com.example.schoolapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(final Student student) {
        return studentRepository.save(student);
    }
}
