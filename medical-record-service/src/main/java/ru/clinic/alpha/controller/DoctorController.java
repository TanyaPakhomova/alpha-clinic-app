package ru.clinic.alpha.controller;

import org.springframework.http.ResponseEntity;
import ru.clinic.alpha.entiti.Doctor;
import org.springframework.web.bind.annotation.*;

import ru.clinic.alpha.service.DoctorServise;
import ru.clinic.alpha.service.DoctorServise;

import java.util.Optional;

// Контроллер для докторов
@RestController
@RequestMapping("/api/doctors")
class DoctorController {
    private final DoctorServise doctorService;

    DoctorController(DoctorServise doctorService) {
        this.doctorService = doctorService;
    }


    // Метод для добавления доктора
    @PostMapping(value = "/addDoctor")
    public ResponseEntity<?>  addDoctor(@RequestBody Doctor doctor) {
       Doctor addedDoctor = doctorService.addDoctor(doctor);
        if (addedDoctor != null) {
            return ResponseEntity.ok(addedDoctor);
        } else {
            return ResponseEntity.badRequest().body("ok");
        }
    }
    @GetMapping("/{doctorId}")
    public ResponseEntity<?> getDoctorDetails(@PathVariable Long doctorId) {
        Optional<Doctor> doctorOptional = doctorService.findDoctorById(Math.toIntExact(doctorId));
        return doctorOptional
                .map(doctor -> ResponseEntity.ok(doctor))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }




}
