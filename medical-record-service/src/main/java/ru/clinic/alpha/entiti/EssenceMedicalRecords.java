package ru.clinic.alpha.entiti;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "essenceMedicalRecords")
public class EssenceMedicalRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int record_id;// (первичный ключ): уникальный идентификатор записи.

   private int patient_id;// (внешний ключ): связь с пациентом.

     private int doctor_id;// (внешний ключ): связь с врачом.*
    @Column(name = "date_of_visit")
    @Temporal(TemporalType.DATE)
    private Date dateOfVisit;//дата визита
    @Column(name = "diagnosis_col")
    private String diagnosis;
    @Column(name = "treatment_col")
   private String treatment; //information about medical consultation.//лечение: информация о медицинской консультации.
    @OneToOne(mappedBy = "patient")
    private Patient patient;
    @OneToOne(mappedBy = "doctor")
    private Doctor doctor;
    public EssenceMedicalRecords(){}

    public int getRecord_id() { return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }


    public Date getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(Date dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }


    public int getRecordId() {
        return record_id;
    }
}
