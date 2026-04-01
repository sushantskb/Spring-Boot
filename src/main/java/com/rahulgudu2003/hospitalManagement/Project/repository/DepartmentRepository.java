package com.rahulgudu2003.hospitalManagement.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahulgudu2003.hospitalManagement.Project.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
}
