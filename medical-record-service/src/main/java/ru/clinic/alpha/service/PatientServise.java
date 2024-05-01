package ru.clinic.alpha.service;

import ru.clinic.alpha.entiti.Patient;
import ru.clinic.alpha.repozitory.PatientRepozitory;

import java.util.Optional;

public class PatientServise {
    private final PatientRepozitory patientRepozitory;

    public PatientServise(PatientRepozitory patientRepozitory) {
        this.patientRepozitory = patientRepozitory;
    }
    public Patient addPatient(Patient patient) {

        return patientRepozitory.save(patient);
    }
    public Patient deletePatient(long patient) {

        return patientRepozitory.delete(patient);
    }

//    public Optional<Patient> authenticateUser(String username, String password) {
//        Optional<User> user = userRepository.findByUsername(username);
//
//        if (user.isPresent() && password.equals(user.get().getPassword())) {
//            return user;
//        }
//        return Optional.empty();
//    }

    public Optional<Patient> findPatientrById(Long patientId) {
        return patientRepozitory.findById(patientId);
    }
    public Optional<Patient> findByPatientname(String lastNamePatient) {
        return Optional.ofNullable(patientRepozitory.saveNamePatient(lastNamePatient));
    }
}
