package com.example.schoolapp.controller;

import com.example.schoolapp.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/school-info")
public class SchoolController {
    private final SchoolService schoolService;

    @GetMapping
    public String getSchoolInfo() {
        return schoolService.getSchoolInfo();
    }

}
