package ru.clinic.alpha.repozitory;

import ru.clinic.alpha.entiti.Doctor;
import ru.clinic.alpha.entiti.Drug;

import java.util.Optional;

public interface DrugRepozitory  extends JpaRepository<Drug, Long> {
    Drug save(Drug drug);
    Optional<Drug> findById(int drugId);


}
