package entiti;

import java.util.Objects;

public class Patient {

    private final int idNamberPassport;
    private int phone;
    private String LastNamePatient;
    private String FirstNamePatient;
    private String adres;


    public Patient(int idNamberPassport, int phone, String lastNamePatient, String firstNamePatient, String adres) {
        this.idNamberPassport = idNamberPassport;
        this.phone = phone;
        LastNamePatient = lastNamePatient;
        FirstNamePatient = firstNamePatient;
        this.adres = adres;
    }

    public int getIdNamberPassport() {
        return idNamberPassport;
    }

    public int getNamberMedicalRecords() {
        return phone;
    }

    public void setNamberMedicalRecords(int namberMedicalRecords) {
        this.phone = namberMedicalRecords;
    }

    public String getLastNamePatient() {
        return LastNamePatient;
    }

    public void setLastNamePatient(String lastNamePatient) {
        LastNamePatient = lastNamePatient;
    }

    public String getFirstNamePatient() {
        return FirstNamePatient;
    }

    public void setFirstNamePatient(String firstNamePatient) {
        FirstNamePatient = firstNamePatient;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return getIdNamberPassport() == patient.getIdNamberPassport() && getNamberMedicalRecords() == patient.getNamberMedicalRecords() && Objects.equals(getLastNamePatient(), patient.getLastNamePatient()) && Objects.equals(getFirstNamePatient(), patient.getFirstNamePatient()) && Objects.equals(getAdres(), patient.getAdres());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdNamberPassport(), getNamberMedicalRecords(), getLastNamePatient(), getFirstNamePatient(), getAdres());
    }

    @Override
    public String toString() {
        return "Patient{" +
                "idNamberPassport=" + idNamberPassport +
                ", namberMedicalRecords=" + phone +
                ", LastNamePatient='" + LastNamePatient + '\'' +
                ", FirstNamePatient='" + FirstNamePatient + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}