package com.example.schoolapp;

import com.example.schoolapp.model.entity.Specialisation;
import com.example.schoolapp.model.entity.Student;
import com.example.schoolapp.model.entity.Teacher;
import com.example.schoolapp.service.StudentService;
import com.example.schoolapp.service.TeacherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SchoolAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolAppApplication.class, args);
    }

    @Bean
    CommandLineRunner addStudents(StudentService studentService) {
        return args -> {
            studentService.addStudent(Student.builder()
                    .name("John")
                    .attendingClass("1A")
                    .build());
            studentService.addStudent(Student.builder()
                    .name("Claudia")
                    .attendingClass("1A")
                    .build());
            studentService.addStudent(Student.builder()
                    .name("Irina")
                    .attendingClass("1B")
                    .build());
        };
    }

    @Bean
    CommandLineRunner addTeachers(TeacherService teacherService) {
        return args -> {
            teacherService.addTeacher(Teacher.builder()
                    .name("Marian")
                    .specialisation(new Specialisation("Math"))
                    .assignedClass("1A")
                    .isAdmin(true)
                    .build());
            teacherService.addTeacher(Teacher.builder()
                    .name("Mary")
                    .specialisation(new Specialisation("English"))
                    .assignedClass("1A")
                    .isAdmin(false)
                    .build());
            teacherService.addTeacher(Teacher.builder()
                    .name("Jane")
                    .specialisation(new Specialisation("History"))
                    .assignedClass("1B")
                    .isAdmin(false)
                    .build());
        };
    }

}
