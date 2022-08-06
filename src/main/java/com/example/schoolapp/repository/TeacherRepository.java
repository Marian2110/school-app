package com.example.schoolapp.repository;

import com.example.schoolapp.model.entity.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
    Optional<Teacher> findByName(String username);
}
