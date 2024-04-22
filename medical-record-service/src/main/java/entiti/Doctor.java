package entiti;

import java.util.Objects;

public class Doctor {

    private final int doctor_id;//pk
    private String doctorLastName;
    private String doctorFirstName;
    private String doctorsSpecialization;

    public Doctor(int doctorId, String doctorLastName, String doctorFirstName, String doctorsSpecialization) {
        doctor_id = doctorId;
        this.doctorLastName = doctorLastName;
        this.doctorFirstName = doctorFirstName;
        this.doctorsSpecialization = doctorsSpecialization;
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
