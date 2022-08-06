package com.example.schoolapp.repository;

import com.example.schoolapp.model.security.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUserId(String username);
}
