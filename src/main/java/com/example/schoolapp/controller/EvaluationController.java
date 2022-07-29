package com.example.schoolapp.controller;

import com.example.schoolapp.model.entity.Evaluation;
import com.example.schoolapp.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher-evaluation")
public class EvaluationController {
    private final EvaluationService evaluationService;

    @PostMapping
    public Evaluation addTeacherEvaluation(@RequestBody final Evaluation evaluation) {
        return evaluationService.addEvaluation(evaluation);

    }

}
