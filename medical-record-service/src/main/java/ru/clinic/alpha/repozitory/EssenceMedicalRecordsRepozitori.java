package ru.clinic.alpha.repozitory;

import ru.clinic.alpha.entiti.EssenceMedicalRecords;
import ru.clinic.alpha.entiti.LaboratoryResults;

import java.util.Optional;

public interface EssenceMedicalRecordsRepozitori extends JpaRepository<EssenceMedicalRecordsRepozitori, Long> {

        EssenceMedicalRecords save(EssenceMedicalRecords essenceMedicalRecords);
        Optional<EssenceMedicalRecords> findById(int recordId);

        void add(EssenceMedicalRecords essenceMedicalRecord);
}
