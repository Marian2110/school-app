package com.example.schoolapp.model.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document("teachers")

public record Teacher(
        @Id
        String id,
        String name,
        Specialisation specialisation,
        String assignedClass,
        Boolean isAdmin
) {
}
