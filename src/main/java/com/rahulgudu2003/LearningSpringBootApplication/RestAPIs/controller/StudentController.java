package com.rahulgudu2003.LearningSpringBootApplication.RestAPIs.controller;

import com.rahulgudu2003.LearningSpringBootApplication.RestAPIs.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/student")
    public StudentDto getStudent() {
        return new StudentDto(4L, "Sushat", "test@gmail.com");
    }
}
