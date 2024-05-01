package ru.clinic.alpha.repozitory;

import ru.clinic.alpha.entiti.LaboratoryResults;

import java.util.Optional;

public interface LaboratoryResultsRepozitory   extends JpaRepository<LaboratoryResultsRepozitory, Long> {
    void deleteById(int resultId);
    Optional<LaboratoryResults> findById(int resultId);

    LaboratoryResults save(LaboratoryResults result);

}
