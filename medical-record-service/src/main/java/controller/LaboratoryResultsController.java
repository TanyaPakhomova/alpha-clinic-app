package controller;

import entiti.LaboratoryResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repozitory.LaboratoryResultsRepozitory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/laboratory-results")
public class LaboratoryResultsController {

    private final List<LaboratoryResults> laboratoryResults = new ArrayList<>();

    @Autowired
    private LaboratoryResultsRepozitory laboratoryResultRepository; //  есть репозиторий для операций с базой данных

    // Добавление нового результата лабораторного исследования
    @PostMapping
    public ResponseEntity<String> addResult(@RequestBody LaboratoryResults result) {
        laboratoryResultRepository.save(result);
        return ResponseEntity.status(HttpStatus.CREATED).body("Результат лабораторного исследования успешно добавлен");
    }

    // Удаление результата лабораторного исследования по result_id
    @DeleteMapping("/{resultId}")
    public ResponseEntity<String> removeResult(@PathVariable int resultId) {
        laboratoryResultRepository.deleteById(resultId);
        return ResponseEntity.ok("Результат лабораторного исследования успешно удален");
    }
    // Поиск результата по названию
    @GetMapping("/search-by-name")
    public ResponseEntity<List<LaboratoryResults>> searchResultByName(@RequestParam String resultName) {
        List<LaboratoryResults> results = laboratoryResults.stream()
                .filter(result -> result.getResultInfo().equalsIgnoreCase(resultName))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(results);
    }
}
