package com.example.schoolapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    private static final String ADMIN = "ADMIN";
    private static final String TEACHER = "TEACHER";

    @Bean
    SecurityFilterChain httpSecurityConfig(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        auth -> auth
                                .mvcMatchers(GET, "/teachers").hasRole(TEACHER)
                                .mvcMatchers(POST, "/teachers").hasRole(ADMIN)
                                .mvcMatchers(DELETE, "/teachers/**").hasRole(ADMIN)
                                .mvcMatchers(GET, "/students").permitAll()
                                .mvcMatchers(POST, "/students").hasAnyRole(TEACHER, ADMIN)
                                .mvcMatchers(DELETE, "/students/**").hasAnyRole(ADMIN)
                                .mvcMatchers( "/me").authenticated()
                )
                .formLogin()
                .and()
                .httpBasic();
        return http.build();
    }
}
