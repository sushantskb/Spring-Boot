package com.rahulgudu2003.hospitalManagement.Project.service;

import org.springframework.stereotype.Service;

import com.rahulgudu2003.hospitalManagement.Project.entity.Insurance;
import com.rahulgudu2003.hospitalManagement.Project.entity.Patient;
import com.rahulgudu2003.hospitalManagement.Project.repository.InsuranceRepository;
import com.rahulgudu2003.hospitalManagement.Project.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        // 1. Fetch the existing patient
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // 2. Link both sides (Bi-directional)
        // This is crucial for Hibernate to 'see' the relationship
        patient.setInsurance(insurance);
        insurance.setPatient(patient);

        // 3. Save the Patient (the owner).
        // Because of CascadeType.PERSIST, this will also INSERT the Insurance.
        return patientRepository.save(patient);
    }

    @Transactional
    public Patient disaccosiateInsurnceFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(null);
        return patient;

    }
}
