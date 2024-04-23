package repozitory;

import entiti.LaboratoryResults;

public interface LaboratoryResultsRepozitory   extends JpaRepository<LaboratoryResultsRepozitory, Long> {
    void deleteById(int resultId);

    void save(LaboratoryResults result);
    // Методы для работы с данными о лекарствах{
}
