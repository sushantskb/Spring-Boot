package com.rahulgudu2003.LearningSpringBootApplication.RestAPIs.service.impl;

import com.rahulgudu2003.LearningSpringBootApplication.RestAPIs.dto.AddStudentRequestDto;
import com.rahulgudu2003.LearningSpringBootApplication.RestAPIs.dto.StudentDto;
import com.rahulgudu2003.LearningSpringBootApplication.RestAPIs.entity.Student;
import com.rahulgudu2003.LearningSpringBootApplication.RestAPIs.repository.StudentRespository;
import com.rahulgudu2003.LearningSpringBootApplication.RestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRespository studentRespository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRespository.findAll();

        return students.stream().map(student -> modelMapper.map(student, StudentDto.class)).toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRespository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with Id: " + id));

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRespository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRespository.existsById(id)) {
            throw new IllegalArgumentException("Student doesnot exists by id:" + id);
        }
        studentRespository.deleteById(id);

    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRespository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID:" + id));

        modelMapper.map(addStudentRequestDto, student);
        studentRespository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRespository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID:" + id));
        updates.forEach((field, value) -> {
            switch (field) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        });
        Student savedStudent = studentRespository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }
}
