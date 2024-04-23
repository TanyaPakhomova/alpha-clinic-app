package controller;

import entiti.Drug;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Контроллер для лекарств
@RestController
@RequestMapping("/api/drugs")
class DrugController {

    private List<Drug> drugs = new ArrayList<>();

    // Метод для добавления лекарства
    @PostMapping
    public String addDrug(@RequestBody Drug drug) {
        // Валидация данных и создание нового лекарства
        // Надо ли...

        // Добавление новой записи в базу данных
        drugs.add(drug);
        return "Лекарство успешно добавлено";
    }

    // Метод для удаления лекарства по ID
    @DeleteMapping("/{drugId}")
    public String deleteDrug(@PathVariable int drugId) {
        // Поиск лекарства по ID
        Drug drugToDelete = drugs.stream()
                .filter(d -> d.getDrugId() == drugId)
                .findFirst()
                .orElse(null);

        if (drugToDelete != null) {
            drugs.remove(drugToDelete);
            return "Лекарство успешно удалено";
        } else {
            return "Лекарство не найдено";
        }
    }
    // Метод для поиска лекарства по названию
    @GetMapping("/search")
    public Drug searchDrugByName(@RequestParam String drugName) {
        // Поиск лекарства по названию
        return drugs.stream()
                .filter(d -> d.getDrugName().equalsIgnoreCase(drugName))
                .findFirst()
                .orElse(null);
    }

    // Метод для удаления лекарства по названию
    @DeleteMapping("/delete")
    public String deleteDrugByName(@RequestParam String drugName) {
        // Поиск лекарства по названию
        Drug drugToDelete = drugs.stream()
                .filter(d -> d.getDrugName().equalsIgnoreCase(drugName))
                .findFirst()
                .orElse(null);

        if (drugToDelete != null) {
            drugs.remove(drugToDelete);
            return "Лекарство успешно удалено";
        } else {
            return "Лекарство не найдено";
        }
    }
}

