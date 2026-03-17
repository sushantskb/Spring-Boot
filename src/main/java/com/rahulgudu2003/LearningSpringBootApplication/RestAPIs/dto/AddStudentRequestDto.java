package com.rahulgudu2003.LearningSpringBootApplication.RestAPIs.dto;

import lombok.Data;

@Data
public class AddStudentRequestDto {
    private String name;
    private String email;
}
