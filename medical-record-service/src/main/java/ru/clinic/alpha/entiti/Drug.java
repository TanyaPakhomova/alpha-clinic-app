package ru.clinic.alpha.entiti;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "drug")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int drug_id;
    @Column(name = "drug_Name")
    public String drugName;
    @Column(name = "drag_Dose")
    public Double dragDose;
    @Column(name = "information_of_drug")
    public String informationOfDrug;
    @OneToOne(mappedBy = "patient")
    private Patient patient;

    public Drug() {}

    public int getDrug_id() {
        return drug_id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public void setDrug_id(int drug_id) {
        this.drug_id = drug_id;
    }

    public Double getDragDose() {
        return dragDose;
    }

    public void setDragDose(Double dragDose) {
        this.dragDose = dragDose;
    }

    public String getInformationOfDrug() {
        return informationOfDrug;
    }

    public void setInformationOfDrug(String informationOfDrug) {
        this.informationOfDrug = informationOfDrug;
    }

    public int getDrugId() {
        return 0;
    }
}
