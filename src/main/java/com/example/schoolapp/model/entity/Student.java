package com.example.schoolapp.model.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document("students")
public record Student(
        @Id
        String id,
        String name,
        String attendingClass
) {
}
