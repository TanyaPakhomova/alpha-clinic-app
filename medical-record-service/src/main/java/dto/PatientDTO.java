package dto;

import java.util.Objects;

public class PatientDTO {
    private  int idNamberPassport;
    private int phone;
    private String LastNamePatient;
    private String FirstNamePatient;
    private String adres;

public PatientDTO(){};
    public int getIdNamberPassport() {
        return idNamberPassport;
    }

    public void setIdNamberPassport(int idNamberPassport) {
        this.idNamberPassport = idNamberPassport;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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
        if (!(o instanceof PatientDTO that)) return false;
        return idNamberPassport == that.idNamberPassport && getPhone() == that.getPhone() && Objects.equals(LastNamePatient, that.LastNamePatient) && Objects.equals(FirstNamePatient, that.FirstNamePatient) && Objects.equals(adres, that.adres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNamberPassport, getPhone(), LastNamePatient, FirstNamePatient, adres);
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "idNamberPassport=" + idNamberPassport +
                ", phone=" + phone +
                ", LastNamePatient='" + LastNamePatient + '\'' +
                ", FirstNamePatient='" + FirstNamePatient + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}
