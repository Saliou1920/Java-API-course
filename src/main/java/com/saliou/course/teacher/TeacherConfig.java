package com.saliou.course.teacher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TeacherConfig {
    @Bean
    public CommandLineRunner init(TeacherRepository teacherRepository) {
        return args -> {
            Teacher saliou = new Teacher(
                    "Saliou",
                    "diop.saliou@gmail.com",
                    "44 Donald Dr",
                    "506-555-5555"
            );
            teacherRepository.save(saliou);
        };
    }
}
