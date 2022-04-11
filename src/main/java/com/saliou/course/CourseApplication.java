package com.saliou.course;

import com.saliou.course.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {

		SpringApplication.run(CourseApplication.class, args);
	}
}
