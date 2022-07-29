package com.example.schoolapp.controller;

import com.example.schoolapp.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schools")
public class SchoolController {
    private final SchoolService schoolService;

    @GetMapping("/{{id}}/info")
    public String getSchoolInfo(@PathVariable String id) {
        return schoolService.getSchoolInfo();
    }

}
