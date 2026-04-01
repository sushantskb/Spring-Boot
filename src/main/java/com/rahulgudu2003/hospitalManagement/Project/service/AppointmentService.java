package com.rahulgudu2003.hospitalManagement.Project.service;

import org.springframework.stereotype.Service;

import com.rahulgudu2003.hospitalManagement.Project.entity.Appointment;
import com.rahulgudu2003.hospitalManagement.Project.entity.Doctor;
import com.rahulgudu2003.hospitalManagement.Project.entity.Patient;
import com.rahulgudu2003.hospitalManagement.Project.repository.AppointmentRepository;
import com.rahulgudu2003.hospitalManagement.Project.repository.DoctorRepository;
import com.rahulgudu2003.hospitalManagement.Project.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    private final DoctorRepository doctorRepository;

    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if (appointment.getId() != null)
            throw new IllegalArgumentException("New appointment cannot have an ID");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment); // maintain bi-directional consistency

        return appointmentRepository.save(appointment);

    }

    @Transactional
    public Appointment reassignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        appointment.setDoctor(doctor);
        return appointment;
    }
}
