package ru.clinic.alpha.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long appointmentId;

    @Column(name = "appointment_time", nullable = false)
    private LocalDateTime appointmentTime;

    @Column(name = "patient_name", nullable = false, length = 255)
    private String patientName;

    @Column(name = "doctor_name", nullable = false, length = 255)
    private String doctorName;

    @Column(name = "specialization", length = 255)
    private String specialization;

    @Column(name = "notes", columnDefinition = "TEXT")
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

