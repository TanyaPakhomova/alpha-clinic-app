package ru.clinic.alpha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.clinic.alpha.exception.UserNotFoundException;
import ru.clinic.alpha.model.Appointment;
import ru.clinic.alpha.repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final RestClient userClient;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
        this.userClient = RestClient.builder()
                .baseUrl("http://api-gateway:8080/api/users/search/")
                .build();
    }

    public boolean checkDoctorAvailability(String doctorName, LocalDateTime dateTime) {
        return appointmentRepository.countByDoctorNameAndAppointmentTime(doctorName, dateTime) == 0;
    }

    public Appointment scheduleAppointment(Appointment appointment) {
        // go to user service
        String patient = appointment.getPatientName();
        var status = userClient.get()
                .uri(patient)
                .retrieve()
                .toBodilessEntity()
                .getStatusCode();
        if (status.equals(HttpStatusCode.valueOf(404))) {
            throw new UserNotFoundException();
        }

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
