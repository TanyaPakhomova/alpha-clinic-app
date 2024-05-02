package ru.clinic.alpha.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    private LocalDateTime appointmentTime;

    private String patientName;

    private String doctorName;

    private String specialization;

    private String notes;

    public Appointment() {
    }

    public Appointment(LocalDateTime appointmentTime, String patientName, String doctorName, String specialization, String notes) {
        this.appointmentTime = appointmentTime;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.notes = notes;
    }

    public Appointment(Long appointmentId, LocalDateTime appointmentTime, String patientName, String doctorName, String specialization, String notes) {
        this.appointmentId = appointmentId;
        this.appointmentTime = appointmentTime;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.notes = notes;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

