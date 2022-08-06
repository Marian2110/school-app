package com.example.schoolapp.service;

import com.example.schoolapp.model.security.User;
import com.example.schoolapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Random random = new Random();

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public void addUser(String id) {
        String rawPassword = generateRandomPassword();
        User user = User.builder()
                .userId(id)
                .password(passwordEncoder.encode(rawPassword))
                .build();
        userRepository.save(user);
        log.info("User {} was added with password {}", id, rawPassword);
        sendPasswordToTeacher(id, rawPassword);
    }

    private void sendPasswordToTeacher(String id, String password) {
        // Just in development. I know that logging password is not a good idea :)
        log.info("Password {} and was send to user {}", password, id);
    }

    private String generateRandomPassword() {
        return String.valueOf(random.nextInt(1000000));
    }

}
