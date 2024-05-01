package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clinic.alpha.controller.AppointmentController;
import ru.clinic.alpha.exception.NotFoundException;
import ru.clinic.alpha.model.Appointment;
import ru.clinic.alpha.service.AppointmentService;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppointmentControllerTest {

    @Mock
    private AppointmentService appointmentService;

    @InjectMocks
    private AppointmentController appointmentController;

    private Appointment appointment;

    @BeforeEach
    void setUp() {
        appointment = new Appointment(
                1L,
                LocalDateTime.of(2023, 10, 10, 10, 0),
                "John Doe",
                "Dr. Smith",
                "Cardiology",
                "Patient notes"
        );
    }

    @Test
    void testCheckDoctorAvailability() {
        when(appointmentService.checkDoctorAvailability("Dr. Smith", LocalDateTime.of(2023, 10, 10, 10, 0))).thenReturn(true);

        boolean result = appointmentController.checkDoctorAvailability("Dr. Smith", LocalDateTime.of(2023, 10, 10, 10, 0));

        assertTrue(result);
        verify(appointmentService, times(1)).checkDoctorAvailability("Dr. Smith", LocalDateTime.of(2023, 10, 10, 10, 0));
    }

    @Test
    void testScheduleAppointment() {
        when(appointmentService.scheduleAppointment(appointment)).thenReturn(appointment);

        Appointment result = appointmentController.scheduleAppointment(appointment);

        assertEquals("Dr. Smith", result.getDoctorName());
        assertEquals("John Doe", result.getPatientName());
        assertEquals("Cardiology", result.getSpecialization());
        assertEquals("Patient notes", result.getNotes());
        verify(appointmentService, times(1)).scheduleAppointment(appointment);
    }

    @Test
    void testGetAppointmentById() {
        when(appointmentService.getAppointmentById(1L)).thenReturn(Optional.of(appointment));

        Appointment result = appointmentController.getAppointmentById(1L);

        assertEquals("Dr. Smith", result.getDoctorName());
        assertEquals("John Doe", result.getPatientName());
        assertEquals("Cardiology", result.getSpecialization());
        verify(appointmentService, times(1)).getAppointmentById(1L);
    }

    @Test
    void testGetAppointmentById_NotFound() {
        when(appointmentService.getAppointmentById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> appointmentController.getAppointmentById(1L));

        verify(appointmentService, times(1)).getAppointmentById(1L);
    }

    @Test
    void testUpdateAppointment() {
        when(appointmentService.updateAppointment(1L, appointment)).thenReturn(appointment);

        Appointment result = appointmentController.updateAppointment(1L, appointment);

        assertEquals("Dr. Smith", result.getDoctorName());
        assertEquals("John Doe", result.getPatientName());
        assertEquals("Cardiology", result.getSpecialization());
        assertEquals("Patient notes", result.getNotes());
        verify(appointmentService, times(1)).updateAppointment(1L, appointment);
    }

    @Test
    void testCancelAppointment() {
        doNothing().when(appointmentService).cancelAppointment(1L);

        appointmentController.cancelAppointment(1L);

        verify(appointmentService, times(1)).cancelAppointment(1L);
    }
}

