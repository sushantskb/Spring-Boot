package com.rahulgudu2003.LearningSpringBootApplication.RestAPIs.service;

import com.rahulgudu2003.LearningSpringBootApplication.RestAPIs.dto.AddStudentRequestDto;
import com.rahulgudu2003.LearningSpringBootApplication.RestAPIs.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudent(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
