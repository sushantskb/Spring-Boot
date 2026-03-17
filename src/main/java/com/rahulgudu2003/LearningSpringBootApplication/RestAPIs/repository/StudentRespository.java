package com.rahulgudu2003.LearningSpringBootApplication.RestAPIs.repository;

import com.rahulgudu2003.LearningSpringBootApplication.RestAPIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRespository extends JpaRepository<Student, Long> {

}
