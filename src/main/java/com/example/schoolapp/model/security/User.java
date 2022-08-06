package com.example.schoolapp.model.security;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@Builder
public record User(
        @Id
        String userId,
        String password) {
}
