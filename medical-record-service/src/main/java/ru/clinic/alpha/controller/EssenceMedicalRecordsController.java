package ru.clinic.alpha.controller;

import ru.clinic.alpha.entiti.EssenceMedicalRecords;
import org.springframework.web.bind.annotation.*;
import ru.clinic.alpha.repozitory.EssenceMedicalRecordsRepozitori;

import java.util.ArrayList;
import java.util.List;

// Контроллер для медицинских записей
@RestController
@RequestMapping("/api/medical_records")
 class EssenceMedicalRecordController {

    private final EssenceMedicalRecordsRepozitori essenceMedicalRecordsRepozitori;

    public EssenceMedicalRecordController(EssenceMedicalRecordsRepozitori essenceMedicalRecordsRepozitori) {
        this.essenceMedicalRecordsRepozitori = essenceMedicalRecordsRepozitori;
    }

    // Метод для добавления медицинской записи
    @PostMapping
    public String addEssenceMedicalRecord(@RequestBody EssenceMedicalRecords essenceMedicalRecord) {

        // Добавление новой записи в базу данных
        essenceMedicalRecordsRepozitori.add(essenceMedicalRecord);
        return "Медицинская запись успешно добавлена";
    }

//    // Метод для удаления медицинской записи по ID
//    @DeleteMapping("/{recordId}")
//    public String deleteEssenceMedicalRecord(@PathVariable int recordId) {
//        // Поиск записи по ID
//        EssenceMedicalRecordsRepozitori recordToDelete = essenceMedicalRecordsRepozitori.stream()
//                .filter(record -> record.getRecordId() == recordId)
//                .findFirst()
//                .orElse(null);
//
//        if (recordToDelete != null) {
//            essenceMedicalRecords.remove(recordToDelete);
//            return "Медицинская запись успешно удалена";
//        } else {
//            return "Запись не найдена";
//        }
//    }


}
