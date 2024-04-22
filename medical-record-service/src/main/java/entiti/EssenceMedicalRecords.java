package entiti;

import java.util.Objects;

public class EssenceMedicalRecords {
    private int record_id;// (первичный ключ): уникальный идентификатор записи.
    private int patient_id;// (внешний ключ): связь с пациентом.
    private int doctor_id;// (внешний ключ): связь с врачом.
    private int dateOfVisit;//дата визита
    private String diagnosis;
   private String treatment; //information about medical consultation.//лечение: информация о медицинской консультации.

    public void EssenceMedicalRecords(int record_id, int patient_id, int doctor_id, int dateOfVisit, String diagnosis, String treatment) {
        this.record_id = record_id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.dateOfVisit = dateOfVisit;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

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

    public int getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(int dateOfVisit) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EssenceMedicalRecords that)) return false;
        return getRecord_id() == that.getRecord_id() && getPatient_id() == that.getPatient_id() && getDoctor_id() == that.getDoctor_id() && getDateOfVisit() == that.getDateOfVisit() && Objects.equals(getDiagnosis(), that.getDiagnosis()) && Objects.equals(getTreatment(), that.getTreatment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecord_id(), getPatient_id(), getDoctor_id(), getDateOfVisit(), getDiagnosis(), getTreatment());
    }

    @Override
    public String toString() {
        return "EssenceMedicalRecords{" +
                "record_id=" + record_id +
                ", patient_id=" + patient_id +
                ", doctor_id=" + doctor_id +
                ", dateOfVisit=" + dateOfVisit +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }
}
