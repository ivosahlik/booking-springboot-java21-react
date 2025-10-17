package cz.ivosahlik.hotelbooking.config;

import cz.ivosahlik.hotelbooking.entities.User;
import cz.ivosahlik.hotelbooking.enums.UserRole;
import cz.ivosahlik.hotelbooking.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (!userRepository.existsByEmail("admin@example.com")) {
            User adminUser = User.builder()
                    .password(passwordEncoder.encode("admin123"))
                    .email("admin@example.com")
                    .role(UserRole.ADMIN)
                    .phoneNumber("123456789")
                    .build();
            userRepository.save(adminUser);
        }

        if (!userRepository.existsByEmail("user@example.com")) {
            User regularUser = User.builder()
                    .password(passwordEncoder.encode("user123"))
                    .email("user@example.com")
                    .role(UserRole.CUSTOMER)
                    .phoneNumber("123456789")
                    .build();
            userRepository.save(regularUser);
        }
    }
}
