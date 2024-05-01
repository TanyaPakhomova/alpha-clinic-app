package ru.clinic.alpha.controller;

import org.springframework.http.ResponseEntity;
import ru.clinic.alpha.entiti.Doctor;
import ru.clinic.alpha.entiti.Drug;
import org.springframework.web.bind.annotation.*;
import ru.clinic.alpha.repozitory.DrugRepozitory;
import ru.clinic.alpha.service.DrugServise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Контроллер для лекарств
@RestController
@RequestMapping("/api/drugs")
class DrugController {

    private final DrugServise drugServise;


    public DrugController(DrugServise drugServise) {
        this.drugServise = drugServise;
    }

    // Метод для добавления лекарства
    @PostMapping(value = "/addDrug")
    public ResponseEntity<?> addDrug(@RequestBody Drug drug) {
       Drug addedDrug = drugServise.addDrug(drug);
        if (addedDrug != null) {
            return ResponseEntity.ok(addedDrug);
        } else {
            return ResponseEntity.badRequest().body("ok");
        }
    }
    @GetMapping("/{drugId}")
    public ResponseEntity<?> getDrug(@PathVariable Long drugId) {
        Optional<Drug> drugOptional = drugServise.findDrugById(Math.toIntExact(drugId));
        return drugOptional
                .map(drug -> ResponseEntity.ok(drug))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    // Метод для удаления лекарства по ID
//    @DeleteMapping("/{drugId}")
//    public ResponseEntity<?> deleteDrug(@PathVariable int drugId) {
//        // Поиск лекарства по ID
//        Drug drugToDelete = drugServise.s()
//                .filter(d -> drugServise.getDrugId() == drugId)
//                .findFirst()
//                .orElse(null);
//
//        if (drugToDelete != null) {
//           drugToDelete.(drugToDelete);
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

