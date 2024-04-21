package ru.clinic.alpha.controller;

import org.springframework.web.bind.annotation.*;
import ru.clinic.alpha.exception.NotFoundException;
import ru.clinic.alpha.model.Appointment;
import ru.clinic.alpha.service.AppointmentService;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/requests")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/checkAvailability")
    public boolean checkDoctorAvailability(@RequestParam("doctorName") String doctorName,
                                           @RequestParam("dateTime") LocalDateTime dateTime) {
        return appointmentService.checkDoctorAvailability(doctorName, dateTime);
    }

    @PostMapping("/schedule")
    public Appointment scheduleAppointment(@RequestBody Appointment appointment) {
        return appointmentService.scheduleAppointment(appointment);
    }

    @GetMapping("/{appointmentId}")
    public Appointment getAppointmentById(@PathVariable Long appointmentId) {
        return appointmentService.getAppointmentById(appointmentId)
                .orElseThrow(() -> new NotFoundException("Appointment not found"));
    }

    @PutMapping("/{appointmentId}")
    public Appointment updateAppointment(@PathVariable Long appointmentId,
                                         @RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(appointmentId, appointment);
    }

    @DeleteMapping("/{appointmentId}")
    public void cancelAppointment(@PathVariable Long appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
    }
}

