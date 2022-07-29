package com.example.schoolapp.model.entity;

import com.example.schoolapp.model.utils.EvaluatedEntity;
import org.springframework.data.annotation.Id;

public record Evaluation(
        @Id
        String jd,
        String message,
        Integer rating,
        EvaluatedEntity evaluatedEntity,
        String entityId
) {
}
