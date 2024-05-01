package ru.clinic.alpha.controller;

import ru.clinic.alpha.entiti.Doctor;
import org.springframework.web.bind.annotation.*;

import ru.clinic.alpha.service.DoctorServise;
import ru.clinic.alpha.service.DoctorServise;

// Контроллер для докторов
@RestController
@RequestMapping("/api/doctors")
class DoctorController {
    private final DoctorServise doctorService;

    DoctorController(DoctorServise doctorService) {
        this.doctorService = doctorService;
    }


    // Метод для добавления доктора
    @PostMapping
    public String addDoctor(@RequestBody Doctor doctor) {

        // Добавление новой записи в базу данных
        doctorService.addDoctor(doctor);
        return "Доктор успешно добавлен";
    }

//    // Метод для удаления доктора по ID
//    @DeleteMapping("/{doctorId}")
//    public String deleteDoctor(@PathVariable int doctorId) {
//        // Поиск доктора по ID
//        Doctor doctorToDelete = doctorService.findDoctorById()
//                .filter(d -> d.getDoctorId() == doctorId)
//                .findFirst()
//                .orElse(null);
//
//        if (doctorToDelete != null) {
//            doctors.remove(doctorToDelete);
//            return "Доктор успешно удален";
//        } else {
//            return "Доктор не найден";
//        }
//    }
}
