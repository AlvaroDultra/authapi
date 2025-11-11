package com.authapi.config;

import com.authapi.model.User;
import com.authapi.model.enums.Role;
import com.authapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByEmail("admin@authapi.com").isEmpty()) {
            User admin = User.builder()
                    .name("Administrador")
                    .email("admin@authapi.com")
                    .password(passwordEncoder.encode("admin123"))
                    .role(Role.ROLE_ADMIN)
                    .build();

            userRepository.save(admin);
            System.out.println("✅ Usuário ADMIN criado: admin@authapi.com / senha: admin123");
        } else {
            System.out.println("⚙️ Usuário ADMIN já existe.");
        }
    }
}
