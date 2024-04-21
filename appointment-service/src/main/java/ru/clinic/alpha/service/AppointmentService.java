package ru.clinic.alpha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clinic.alpha.model.Appointment;
import ru.clinic.alpha.repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public boolean checkDoctorAvailability(String doctorName, LocalDateTime dateTime) {
        return appointmentRepository.countByDoctorNameAndAppointmentTime(doctorName, dateTime) == 0;
    }

    public Appointment scheduleAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Optional<Appointment> getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    public Appointment updateAppointment(Long appointmentId, Appointment updatedAppointment) {
        return appointmentRepository.findById(appointmentId)
                .map(appointment -> {
                    appointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
                    appointment.setPatientName(updatedAppointment.getPatientName());
                    appointment.setDoctorName(updatedAppointment.getDoctorName());
                    appointment.setSpecialization(updatedAppointment.getSpecialization());
                    appointment.setNotes(updatedAppointment.getNotes());
                    return appointmentRepository.save(appointment);
                })
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
    }

    public void cancelAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
