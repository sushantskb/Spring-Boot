package com.rahulgudu2003.hospitalManagement.Project;

import com.rahulgudu2003.hospitalManagement.Project.entity.Patient;
import com.rahulgudu2003.hospitalManagement.Project.repository.PatientRepository;
import com.rahulgudu2003.hospitalManagement.Project.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class PatientTests {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        // Basic CRUD check using the Repository Proxy
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }

    @Test
    public void testGetPatientById() {
        // Triggering the Service logic to observe Dirty Checking and the Persistence Context
        Patient patient = patientService.getPatientById(1L);
        System.out.println("Returned Patient: " + patient.getName());

        // Note: After this line, the Patient is now in 'Detached' state
        // because the transaction in the service has closed.
    }
}