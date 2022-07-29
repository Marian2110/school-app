package com.example.schoolapp.model.entity;

import org.springframework.data.annotation.Id;


public record Student(
        @Id
        String id,
        String firstName,
        String lastName
) {
}
