package com.example.schoolapp.service;

import com.example.schoolapp.model.entity.Student;
import com.example.schoolapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final UserService userService;


    // Asa nu merge, astept feedback
    @PostFilter("hasRole('TEACHER') OR hasRole('ADMIN') OR filterObject.attendingClass() == studentService.getStudentClassByName(authentication.name)")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(final Student student) {
        Student addedStudent = studentRepository.save(student);
        userService.addUser(addedStudent.id());
        log.info("Student {} was added", addedStudent);
        return addedStudent;
    }

    public void deleteStudent(final String id) {
        studentRepository.deleteById(id);
    }

    public Optional<Student> findByName(String username) {
        return studentRepository.findByName(username);
    }

    public String getStudentClassByName(String name) {
        return studentRepository.findByName(name)
                .map(Student::attendingClass)
                .orElseThrow( () -> new IllegalArgumentException("Student with name " + name + " not found"));
    }
}
