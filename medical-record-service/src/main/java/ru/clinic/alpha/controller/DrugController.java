package ru.clinic.alpha.controller;

import ru.clinic.alpha.entiti.Drug;
import org.springframework.web.bind.annotation.*;
import ru.clinic.alpha.repozitory.DrugRepozitory;

import java.util.ArrayList;
import java.util.List;

// Контроллер для лекарств
@RestController
@RequestMapping("/api/drugs")
class DrugController {

    private final DrugRepozitory drugRepozitory;

    public DrugController(DrugRepozitory drugRepozitory) {
        this.drugRepozitory = drugRepozitory;
    }

    // Метод для добавления лекарства
    @PostMapping
    public String addDrug(@RequestBody Drug drug) {

        // Добавление новой записи в базу данных
        drugRepozitory.save(drug);
        return "Лекарство успешно добавлено";
    }

    // Метод для удаления лекарства по ID
//    @DeleteMapping("/{drugId}")
//    public String deleteDrug(@PathVariable int drugId) {
//        // Поиск лекарства по ID
//        Drug drugToDelete = drugRepozitory.stream()
//                .filter(d -> d.getDrugId() == drugId)
//                .findFirst()
//                .orElse(null);
//
//        if (drugToDelete != null) {
//            drugs.remove(drugToDelete);
//            return "Лекарство успешно удалено";
//        } else {
//            return "Лекарство не найдено";
//        }
//    }
//    // Метод для поиска лекарства по названию
//    @GetMapping("/search")
//    public Drug searchDrugByName(@RequestParam String drugName) {
//        // Поиск лекарства по названию
//        return drugs.stream()
//                .filter(d -> d.getDrugName().equalsIgnoreCase(drugName))
//                .findFirst()
//                .orElse(null);
//    }
//
//    // Метод для удаления лекарства по названию
//    @DeleteMapping("/delete")
//    public String deleteDrugByName(@RequestParam String drugName) {
//        // Поиск лекарства по названию
//        Drug drugToDelete = drugs.stream()
//                .filter(d -> d.getDrugName().equalsIgnoreCase(drugName))
//                .findFirst()
//                .orElse(null);
//
//        if (drugToDelete != null) {
//            drugs.remove(drugToDelete);
//            return "Лекарство успешно удалено";
//        } else {
//            return "Лекарство не найдено";
//        }
//    }
}

