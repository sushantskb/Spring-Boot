package com.rahulgudu2003.hospitalManagement.Project.service;

import com.rahulgudu2003.hospitalManagement.Project.entity.Patient;
import com.rahulgudu2003.hospitalManagement.Project.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional // Starts a Persistence Context (The "Session")
    public Patient getPatientById(Long id){
        // 1. First fetch: Goes to DB, puts Patient in Persistence Context (Managed State)
        Patient p1 = patientRepository.findById(id).orElseThrow();

        // 2. Second fetch: JPA sees ID is already in Context; returns p1's reference!
        // No SQL query is fired for p2. (p1 == p2 is true)
        Patient p2 = patientRepository.findById(id).orElseThrow();

        // 3. Modifying a MANAGED entity:
        // Because of the @Transactional boundary, Hibernate tracks this change.
        p1.setName("Ms Dhoni");

        // 4. Dirty Checking: When this method ends, the transaction commits.
        // Hibernate automatically runs an UPDATE SQL statement here.
        return p1;
    }
}