package dto;

import java.util.Objects;

public class DoctorDTO {
    private  int doctor_id;
    private String doctorLastName;
    private String doctorFirstName;
    private String doctorsSpecialization;


    public  DoctorDTO(){
            }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
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
        if (!(o instanceof DoctorDTO doctorDTO)) return false;
        return getDoctor_id() == doctorDTO.getDoctor_id() && Objects.equals(getDoctorLastName(), doctorDTO.getDoctorLastName()) && Objects.equals(getDoctorFirstName(), doctorDTO.getDoctorFirstName()) && Objects.equals(getDoctorsSpecialization(), doctorDTO.getDoctorsSpecialization());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoctor_id(), getDoctorLastName(), getDoctorFirstName(), getDoctorsSpecialization());
    }

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "doctor_id=" + doctor_id +
                ", doctorLastName='" + doctorLastName + '\'' +
                ", doctorFirstName='" + doctorFirstName + '\'' +
                ", doctorsSpecialization='" + doctorsSpecialization + '\'' +
                '}';
    }
}
