package ru.clinic.alpha.repozitory;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clinic.alpha.entiti.Patient;

import java.util.Optional;

public interface PatientRepozitory extends JpaRepository<Patient, Long> {


    Patient save(Patient patient);
    Optional<Patient> findById(Long patientId);



    Patient saveNamePatient(String lastNamePatient);

    Patient delete(long patient);
}
