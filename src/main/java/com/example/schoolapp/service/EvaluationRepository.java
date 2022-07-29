package com.example.schoolapp.service;

import com.example.schoolapp.model.entity.Evaluation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EvaluationRepository extends MongoRepository<Evaluation, String> {
}
