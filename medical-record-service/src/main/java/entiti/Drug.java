package entiti;

import java.util.Objects;

public class Drug {
    private final int drug_id;// (первичный ключ): уникальный идентификатор лекарства.
    public String drugName;//название
    public Double doseDrag;//  дозировка
    public String informationOfDrug;// примечания: информация о прописанных лекарствах.

    public Drug(int drug_id, String drugName, Double doseDrag, String informationOfDrug) {
        this.drug_id = drug_id;
        this.drugName = drugName;
        this.doseDrag = doseDrag;
        this.informationOfDrug = informationOfDrug;
    }

    public int getDrug_id() {
        return drug_id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Double getDoseDrag() {
        return doseDrag;
    }

    public void setDoseDrag(Double doseDrag) {
        this.doseDrag = doseDrag;
    }

    public String getInformationOfDrug() {
        return informationOfDrug;
    }

    public void setInformationOfDrug(String informationOfDrug) {
        this.informationOfDrug = informationOfDrug;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drug drug)) return false;
        return getDrug_id() == drug.getDrug_id() && Objects.equals(getDrugName(), drug.getDrugName()) && Objects.equals(getDoseDrag(), drug.getDoseDrag()) && Objects.equals(getInformationOfDrug(), drug.getInformationOfDrug());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDrug_id(), getDrugName(), getDoseDrag(), getInformationOfDrug());
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drug_id=" + drug_id +
                ", drugName='" + drugName + '\'' +
                ", doseDrag=" + doseDrag +
                ", informationOfDrug='" + informationOfDrug + '\'' +
                '}';
    }

    public int getDrugId() {
        return 0;
    }
}
