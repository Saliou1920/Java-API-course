package com.saliou.course.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            Student saliou = new Student(
                    "Saliou",
                    "diop.saliou@gmail.com",
                    LocalDate.of(2000, 1, 1)
            );

            Student fallou = new Student(
                    "fallou",
                    "diop.fallou@gmail.com",
                    LocalDate.of(2004, 1, 1)
            );
            repository.saveAll(
                    List.of(saliou, fallou));

        };

    }
}
