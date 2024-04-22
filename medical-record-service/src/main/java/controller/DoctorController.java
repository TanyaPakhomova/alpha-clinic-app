package controller;

import entiti.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Контроллер для докторов
@RestController
@RequestMapping("/api/doctors")
class DoctorController {

    private List<Doctor> doctors = new ArrayList<>();

    // Метод для добавления доктора
    @PostMapping
    public String addDoctor(@RequestBody Doctor doctor) {
        // Валидация данных и создание нового доктора
       //НАДО ЛИ, наверное по паспорту
        // Добавление новой записи в базу данных
        doctors.add(doctor);
        return "Доктор успешно добавлен";
    }

    // Метод для удаления доктора по ID
    @DeleteMapping("/{doctorId}")
    public String deleteDoctor(@PathVariable int doctorId) {
        // Поиск доктора по ID
        Doctor doctorToDelete = doctors.stream()
                .filter(d -> d.getDoctorId() == doctorId)
                .findFirst()
                .orElse(null);

        if (doctorToDelete != null) {
            doctors.remove(doctorToDelete);
            return "Доктор успешно удален";
        } else {
            return "Доктор не найден";
        }
    }
}
