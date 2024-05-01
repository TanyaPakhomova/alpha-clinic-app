package ru.clinic.alpha.controller;

import org.springframework.http.ResponseEntity;
import ru.clinic.alpha.entiti.Doctor;
import ru.clinic.alpha.entiti.EssenceMedicalRecords;
import org.springframework.web.bind.annotation.*;
import ru.clinic.alpha.repozitory.EssenceMedicalRecordsRepozitori;
import ru.clinic.alpha.service.EssenceMedicalRecordsServise;

import java.util.ArrayList;
import java.util.List;


// Контроллер для медицинских записей
@RestController
@RequestMapping("/api/medical_records")
 class EssenceMedicalRecordController {

    private final EssenceMedicalRecordsServise essenceMedicalRecordsServise;

    public EssenceMedicalRecordController(EssenceMedicalRecordsServise essenceMedicalRecordsServise) {
        this.essenceMedicalRecordsServise = essenceMedicalRecordsServise;
    }

    // Метод для добавления медицинской записи
    @PostMapping(value = "/addEssenceMedicalRecord")
    public ResponseEntity<?> addEssenceMedicalRecord(@RequestBody EssenceMedicalRecords essenceMedicalRecord) {

        // Добавление новой записи в базу данных
        EssenceMedicalRecords addEsMedRec = essenceMedicalRecordsServise.addEssenceMedicalRecords(essenceMedicalRecord);
        if (addEsMedRec != null) {
            return ResponseEntity.ok(addEsMedRec);
        } else {
            return ResponseEntity.badRequest().body("ok");
        }
    }

//    // Метод для удаления медицинской записи по ID
//    @DeleteMapping("/{recordId}")
//    public ResponseEntity<?> delDoctor(@RequestBody EssenceMedicalRecords essenceMedicalRecords) {
//        EssenceMedicalRecords addedDoctor = essenceMedicalRecordsServise.d;
//        if (addedDoctor != null) {
//            return ResponseEntity.ok(addedDoctor);
//        } else {
//            return ResponseEntity.badRequest().body("ok");
//        }
//    }

    }



