package com.example.schoolapp.config;

import com.example.schoolapp.model.security.CustomUserDetails;
import com.example.schoolapp.model.security.User;
import com.example.schoolapp.service.StudentService;
import com.example.schoolapp.service.TeacherService;
import com.example.schoolapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final UserService myUserService;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return studentService.findByName(username)
                .map(student -> new CustomUserDetails(student.name(), getUserPasswordById(student.id()), student.attendingClass(), List.of("ROLE_STUDENT")))
                .orElseGet(() -> teacherService.findByName(username)
                        .map(teacher -> new CustomUserDetails(teacher.name(), getUserPasswordById(teacher.id()), teacher.assignedClass(), getTeacherRoles(teacher.isAdmin())))
                        .orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }

    private List<String> getTeacherRoles(Boolean admin) {
        return Boolean.TRUE.equals(admin) ? List.of("ROLE_TEACHER", "ROLE_ADMIN") : List.of("ROLE_TEACHER");
    }

    private String getUserPasswordById(String id) {
        return myUserService.getUserById(id)
                .map(User::password)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }
}
