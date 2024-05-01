package ru.clinic.alpha.entiti;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "laboratory_results")
public class LaboratoryResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int result_id;
    private int patient_id;
    @Column(name = "date_of_study")
    @Temporal(TemporalType.DATE)
    private Date dateOfStudy;
    @Column(name = "type_of_analysis")
    private String typeOfAnalysis;
    @Column(name = "result_information_about_laboratory_tests")
    private String resultInformationAboutLaboratoryTests;
    @OneToOne(mappedBy = "patient")
    private Patient patient;

    public LaboratoryResults() {}

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getTypeOfAnalysis() {
        return typeOfAnalysis;
    }

    public void setTypeOfAnalysis(String typeOfAnalysis) {
        this.typeOfAnalysis = typeOfAnalysis;
    }

    public String getResultInformationAboutLaboratoryTests() {
        return resultInformationAboutLaboratoryTests;
    }

    public void setResultInformationAboutLaboratoryTests(String resultInformationAboutLaboratoryTests) {
        this.resultInformationAboutLaboratoryTests = resultInformationAboutLaboratoryTests;
    }

    public Date getDateOfStudy() {
        return dateOfStudy;
    }

    public void setDateOfStudy(Date dateOfStudy) {
        this.dateOfStudy = dateOfStudy;
    }

    @Override
    public String toString() {
        return "LaboratoryResults{" +
                "result_id=" + result_id +
                ", patient_id=" + patient_id +
                ", dateOfStudy=" + dateOfStudy +
                ", typeOfAnalysis='" + typeOfAnalysis + '\'' +
                ", resultInformationAboutLaboratoryTests='" + resultInformationAboutLaboratoryTests + '\'' +
                '}';
    }

    public String getResultInfo() {
        return null;
    }
}

