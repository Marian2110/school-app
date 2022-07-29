package com.example.schoolapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private static final String SCHOOL_INFO = "My school info";

    public String getSchoolInfo() {
        return SCHOOL_INFO;
    }
}
