package controller;

import entiti.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repozitory.PatientRepozitory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final List<Patient> patients = new ArrayList<>();

    @Autowired
    private PatientRepozitory patientRepository; //  репозиторий для операций с базой данных

    // Добавление нового пациента
    @PostMapping
    public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
        patientRepository.save(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body("Пациент успешно добавлен");
    }

    // Удаление пациента по idNamberPassport
    @DeleteMapping("/{idNamberPassport}")
    public ResponseEntity<String> removePatient(@PathVariable int idNamberPassport) {
        patientRepository.deleteById(idNamberPassport);
        return ResponseEntity.ok("Пациент успешно удален");
    }

    // Поиск пациента по фамилии
    @GetMapping("/search-by-last-name")
    public ResponseEntity<List<Patient>> searchPatientByLastName(@RequestParam String lastName) {
        List<Patient> foundPatients = patients.stream()
                .filter(patient -> patient.getLastNamePatient().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());

        if (foundPatients.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(foundPatients);
    }
}
