package ru.clinic.alpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clinic.alpha.model.Appointment;

import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    long countByDoctorNameAndAppointmentTime(String doctorName, LocalDateTime dateTime);
}

