package entiti;

import java.util.Objects;

public class LaboratoryResults {
    private int result_id;// (первичный ключ): уникальный идентификатор результата.
    private int patient_id;// (внешний ключ): связь с пациентом.
    private int dateOfStudy;//дата исследования
    private String typeOfAnalysis;//тип анализа
    private String resultInformationAboutLaboratoryTests;// результат: информация о лабораторных тестах.

    public LaboratoryResults(int result_id,
                             int patient_id,
                             int dateOfStudy,
                             String typeOfAnalysis,
                             String resultInformationAboutLaboratoryTests) {
        this.result_id = result_id;
        this.patient_id = patient_id;
        this.dateOfStudy = dateOfStudy;
        this.typeOfAnalysis = typeOfAnalysis;
        this.resultInformationAboutLaboratoryTests = resultInformationAboutLaboratoryTests;
    }

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

    public int getDateOfStudy() {
        return dateOfStudy;
    }

    public void setDateOfStudy(int dateOfStudy) {
        this.dateOfStudy = dateOfStudy;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LaboratoryResults that)) return false;
        return getResult_id() == that.getResult_id() && getPatient_id() == that.getPatient_id() && getDateOfStudy() == that.getDateOfStudy() && Objects.equals(getTypeOfAnalysis(), that.getTypeOfAnalysis()) && Objects.equals(getResultInformationAboutLaboratoryTests(), that.getResultInformationAboutLaboratoryTests());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResult_id(), getPatient_id(), getDateOfStudy(), getTypeOfAnalysis(), getResultInformationAboutLaboratoryTests());
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
}

