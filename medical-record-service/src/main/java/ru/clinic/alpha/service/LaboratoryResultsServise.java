package ru.clinic.alpha.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clinic.alpha.entiti.LaboratoryResults;
import ru.clinic.alpha.repozitory.LaboratoryResultsRepozitory;
import java.util.Optional;

@Service
public class LaboratoryResultsServise {

    private final LaboratoryResultsRepozitory laboratoryResultsRepozitory;

    public LaboratoryResultsServise(LaboratoryResultsRepozitory laboratoryResultsRepozitory) {
        this.laboratoryResultsRepozitory = laboratoryResultsRepozitory;
    }

    @Autowired
    public LaboratoryResults addLaboratoryResults(LaboratoryResults laboratoryResults) {

        return laboratoryResultsRepozitory.save(laboratoryResults);
    }

    public Optional<LaboratoryResults> findLaboratoryResultsById(Integer resultId) {
        return laboratoryResultsRepozitory.findById(resultId);
    }
}
