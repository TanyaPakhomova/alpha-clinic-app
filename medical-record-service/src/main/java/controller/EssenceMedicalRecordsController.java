package controller;

import entiti.EssenceMedicalRecords;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Контроллер для медицинских записей
@RestController
@RequestMapping("/api/medical_records")
 class EssenceMedicalRecordController {

    private List<EssenceMedicalRecords> essenceMedicalRecords = new ArrayList<>();

    // Метод для добавления медицинской записи
    @PostMapping
    public String addEssenceMedicalRecord(@RequestBody EssenceMedicalRecords essenceMedicalRecord) {
        // Валидация данных и создание новой медицинской записи
        // ...

        // Добавление новой записи в базу данных
        essenceMedicalRecords.add(essenceMedicalRecord);
        return "Медицинская запись успешно добавлена";
    }

    // Метод для удаления медицинской записи по ID
    @DeleteMapping("/{recordId}")
    public String deleteEssenceMedicalRecord(@PathVariable int recordId) {
        // Поиск записи по ID
        EssenceMedicalRecords recordToDelete = essenceMedicalRecords.stream()
                .filter(record -> record.getRecordId() == recordId)
                .findFirst()
                .orElse(null);

        if (recordToDelete != null) {
            essenceMedicalRecords.remove(recordToDelete);
            return "Медицинская запись успешно удалена";
        } else {
            return "Запись не найдена";
        }
    }


}
