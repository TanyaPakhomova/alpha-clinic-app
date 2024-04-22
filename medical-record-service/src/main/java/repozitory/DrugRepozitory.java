package repozitory;

import entiti.Drug;

public interface DrugRepozitory  extends JpaRepository<Drug, Long> {
    // Методы для работы с данными о лекарствах
}
