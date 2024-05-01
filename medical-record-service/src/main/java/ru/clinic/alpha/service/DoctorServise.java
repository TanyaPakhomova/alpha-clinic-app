package ru.clinic.alpha.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clinic.alpha.entiti.Doctor;
import ru.clinic.alpha.entiti.EssenceMedicalRecords;
import ru.clinic.alpha.entiti.LaboratoryResults;
import ru.clinic.alpha.repozitory.DoctorRepozitory;
import ru.clinic.alpha.repozitory.EssenceMedicalRecordsRepozitori;
import ru.clinic.alpha.repozitory.LaboratoryResultsRepozitory;
import java.util.Optional;

@Service
public class DoctorServise {
    private final DoctorRepozitory doctorRepozitory;

    public DoctorServise(DoctorRepozitory doctorRepozitory) {
        this.doctorRepozitory = doctorRepozitory;
    }

    @Autowired
    public Doctor addDoctor(Doctor doctor) {

        return doctorRepozitory.save(doctor);
    }

    public Optional<Doctor> findDoctorById(Integer doctorId ) {
        return doctorRepozitory.findById(doctorId);
    }
}
