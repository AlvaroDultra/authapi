package com.authapi.config;

import com.authapi.model.User;
import com.authapi.model.enums.Role;
import com.authapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            userRepository.save(User.builder()
                    .name("Admin")
                    .email("admin@authapi.com")
                    .password(passwordEncoder.encode("123456"))
                    .role(Role.ROLE_ADMIN)
                    .build());
        }
    }
}
