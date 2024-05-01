package ru.clinic.alpha.repozitory;

import ru.clinic.alpha.entiti.Doctor;
import ru.clinic.alpha.entiti.LaboratoryResults;

import java.util.Optional;

public interface DoctorRepozitory  extends JpaRepository<Doctor, Long> {
    Doctor save(Doctor doctor);
    Optional<Doctor> findById(int doctorId);


}
