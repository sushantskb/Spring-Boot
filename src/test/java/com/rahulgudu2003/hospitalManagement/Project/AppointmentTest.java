package com.rahulgudu2003.hospitalManagement.Project;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rahulgudu2003.hospitalManagement.Project.entity.Appointment;
import com.rahulgudu2003.hospitalManagement.Project.service.AppointmentService;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder().appointmentTime(LocalDateTime.of(2026, 11, 24, 12, 22, 45))
        .reason("Cancer")
        .build();


         var newAppointment = appointmentService.createNewAppointment(appointment, 1L, 1L);

        System.out.println(newAppointment);

        var updatedAppointment = appointmentService.reassignAppointmentToAnotherDoctor(newAppointment.getId(), 3L);

        System.out.println(updatedAppointment);
    }

    
}
