package com.rahulgudu2003.hospitalManagement.Project;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rahulgudu2003.hospitalManagement.Project.entity.Insurance;
import com.rahulgudu2003.hospitalManagement.Project.entity.Patient;
import com.rahulgudu2003.hospitalManagement.Project.service.InsuranceService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    @Transactional
    @org.springframework.test.annotation.Commit // Add this to see data in Neon!
    public void testInsurance() {
        Insurance insurance = Insurance.builder()
                .provider("HDFC")
                .policyNumber("HDFC_1234")
                .validUntil(LocalDate.of(2030, 12, 12))
                .build(); // createdAt is handled by @PrePersist now

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);

        System.out.println("Saved Patient: " + patient);

        var newPatient = insuranceService.disaccosiateInsurnceFromPatient(1L);

        System.out.println("After disassociation: " + newPatient);
    }
}