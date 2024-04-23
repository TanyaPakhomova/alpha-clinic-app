package repozitory;

import entiti.Patient;

public interface PatientRepozitory extends JpaRepository<Patient, Long> {
    void save(Patient patient);

    void deleteById(int idNamberPassport);

    // Методы для работы с данными о пациентах
}
