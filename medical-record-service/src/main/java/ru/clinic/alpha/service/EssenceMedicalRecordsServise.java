package ru.clinic.alpha.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clinic.alpha.entiti.EssenceMedicalRecords;
import ru.clinic.alpha.entiti.LaboratoryResults;
import ru.clinic.alpha.repozitory.EssenceMedicalRecordsRepozitori;

import java.util.Optional;

@Service
public class EssenceMedicalRecordsServise {

    private final EssenceMedicalRecordsRepozitori essenceMedicalRecordsRepozitori;

    public EssenceMedicalRecordsServise(EssenceMedicalRecordsRepozitori essenceMedicalRecordsRepozitori) {
        this.essenceMedicalRecordsRepozitori = essenceMedicalRecordsRepozitori;
    }


    @Autowired
    public EssenceMedicalRecords addEssenceMedicalRecords(EssenceMedicalRecords essenceMedicalRecords) {

        return essenceMedicalRecordsRepozitori.save(essenceMedicalRecords);
    }

    public Optional<EssenceMedicalRecords> findEssenceMedicalRecordById(Integer recordId ) {
        return essenceMedicalRecordsRepozitori.findById(recordId);
    }
}
