package ru.clinic.alpha.entiti;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int patientId;
    @Column(name = "phone_Patient")
    private int phone;
    @Column(name = "lastName_Patient")
    private String lastNamePatient;
    @Column(name = "fistName_Patient")
    private String firstNamePatient;
    @Column(name = "address_Patient")
    private String addressPatient;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id")
    private EssenceMedicalRecords essenceMedicalRecords;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id")
    private LaboratoryResults laboratoryResults;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "drug_id")
    private Drug drug;
    public Patient() {}

    public int getPatientId() {
        return patientId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddressPatient() {
        return addressPatient;
    }

    public void setAddressPatient(String addressPatient) {
        this.addressPatient = addressPatient;
    }

    public String getLastNamePatient() {
        return lastNamePatient;
    }


    public void setLastNamePatient(String lastNamePatient) {
        this.lastNamePatient = lastNamePatient;
    }

    public String getFirstNamePatient() {
        return firstNamePatient;
    }

    public void setFirstNamePatient(String firstNamePatient) {
        this.firstNamePatient = firstNamePatient;
    }

    public EssenceMedicalRecords getEssenceMedicalRecords() {
        return essenceMedicalRecords;
    }

    public void setEssenceMedicalRecords(EssenceMedicalRecords essenceMedicalRecords) {
        this.essenceMedicalRecords = essenceMedicalRecords;
    }

    public LaboratoryResults getLaboratoryResults() {
        return laboratoryResults;
    }

    public void setLaboratoryResults(LaboratoryResults laboratoryResults) {
        this.laboratoryResults = laboratoryResults;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
