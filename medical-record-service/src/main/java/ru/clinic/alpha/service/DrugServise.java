package ru.clinic.alpha.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.clinic.alpha.entiti.Doctor;
import ru.clinic.alpha.entiti.Drug;
import ru.clinic.alpha.repozitory.DoctorRepozitory;
import ru.clinic.alpha.repozitory.DrugRepozitory;

import java.util.Optional;

public class DrugServise {
    private final DrugRepozitory drugRepozitory;

    public DrugServise(DrugRepozitory drugRepozitory) {
        this.drugRepozitory = drugRepozitory;
    }

    @Autowired
    public Drug addDrug(Drug drug) {

        return drugRepozitory.save(drug);
    }

    public Optional<Drug> findDoctorById(Integer drugId ) {
        return drugRepozitory.findById(drugId);
    }
}
