package com.example.demo.configuration;

import com.example.demo.entity.User;
import com.example.demo.enums.Role;
import com.example.demo.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {

    /**
     *  Autowired để Spring sẽ tự động tiêm một đối tượng của PasswordEncoder
     *  vào passwordEncode mà không cần bạn phải khởi tạo thủ công.
     */
    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        return args -> {
           if ( userRepository.findByUsername("admin").isEmpty()) {
               var roles = new HashSet<String>();
               roles.add(Role.ADMIN.name());
               User user = User.builder()
                       .username("admin")
                       .password(passwordEncoder.encode("admin"))
                       .roles(roles)
                       .build();

               userRepository.save(user);
               log.warn("default user has been created with default password: amin, please change it");
           }
        };
    }
}
