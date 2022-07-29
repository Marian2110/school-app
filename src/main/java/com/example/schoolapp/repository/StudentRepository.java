package com.example.schoolapp.repository;

import com.example.schoolapp.model.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Student> {
}
