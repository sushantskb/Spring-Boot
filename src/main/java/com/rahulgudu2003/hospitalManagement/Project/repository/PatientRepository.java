package com.rahulgudu2003.hospitalManagement.Project.repository;

import com.rahulgudu2003.hospitalManagement.Project.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
