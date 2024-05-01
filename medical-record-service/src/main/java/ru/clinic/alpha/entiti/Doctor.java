package ru.clinic.alpha.entiti;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "doctor_tab")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int doctor_id;//pk
    @Column(name = "lastName_Doctor")
    private String doctorLastName;
    @Column(name = "firstName_Doctor")
    private String doctorFirstName;
    @Column(name = "specialization_Doctor")
    private String doctorsSpecialization;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id")
    private EssenceMedicalRecords essenceMedicalRecords;

    public Doctor() {}

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public EssenceMedicalRecords getEssenceMedicalRecords() {
        return essenceMedicalRecords;
    }

    public void setEssenceMedicalRecords(EssenceMedicalRecords essenceMedicalRecords) {
        this.essenceMedicalRecords = essenceMedicalRecords;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorsSpecialization() {
        return doctorsSpecialization;
    }

    public void setDoctorsSpecialization(String doctorsSpecialization) {
        this.doctorsSpecialization = doctorsSpecialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor doctor)) return false;
        return getDoctor_id() == doctor.getDoctor_id() && Objects.equals(getDoctorLastName(), doctor.getDoctorLastName()) && Objects.equals(getDoctorFirstName(), doctor.getDoctorFirstName()) && Objects.equals(getDoctorsSpecialization(), doctor.getDoctorsSpecialization());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoctor_id(), getDoctorLastName(), getDoctorFirstName(), getDoctorsSpecialization());
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor_id=" + doctor_id +
                ", doctorLastName='" + doctorLastName + '\'' +
                ", doctorFirstName='" + doctorFirstName + '\'' +
                ", doctorsSpecialization='" + doctorsSpecialization + '\'' +
                '}';
    }

    public int getDoctorId() {
        return 0;
    }
}
