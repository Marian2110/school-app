package com.example.schoolapp.repository;

import com.example.schoolapp.model.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findByName(String username);
}
