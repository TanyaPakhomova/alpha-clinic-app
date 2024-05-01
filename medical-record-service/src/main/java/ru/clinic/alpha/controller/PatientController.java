package ru.clinic.alpha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clinic.alpha.entiti.Patient;
import ru.clinic.alpha.repozitory.PatientRepozitory;
import ru.clinic.alpha.service.PatientServise;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/patients")
public class PatientController {



    @Autowired
    private PatientServise patientServise; //  репозиторий для операций с базой данных

    // Добавление нового пациента
    @PostMapping
    public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
        patientServise.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body("Пациент успешно добавлен");
    }

    // Удаление пациента по id
    @DeleteMapping("/{patientId}")
    public ResponseEntity<String> removePatient(@PathVariable int patientId) {
        patientServise.deletePatient((long) patientId);
        return ResponseEntity.ok("Пациент успешно удален");
    }


}
