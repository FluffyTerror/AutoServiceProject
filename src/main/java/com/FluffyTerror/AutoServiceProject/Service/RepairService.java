package com.FluffyTerror.AutoServiceProject.Service;

import com.FluffyTerror.AutoServiceProject.Model.Defect;
import com.FluffyTerror.AutoServiceProject.Model.Repair;
import com.FluffyTerror.AutoServiceProject.Model.Worker;
import com.FluffyTerror.AutoServiceProject.Repository.DefectRepository;
import com.FluffyTerror.AutoServiceProject.Repository.RepairRepository;
import com.FluffyTerror.AutoServiceProject.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {
    @Autowired
    private RepairRepository repairRepository;
    @Autowired
    private DefectRepository defectRepository;

    @Autowired
    private WorkerRepository workerRepository;

    public Repair getRepairDetailsByDefectId(Long defectId) {
        return repairRepository.findByDefectId(defectId)
                .orElseThrow(() -> new IllegalArgumentException("Repair not found for defect ID: " + defectId));
    }
    public List<Object[]> getRepairWorkerByDefectId(Long defectId) {
        return repairRepository.findRepairWorkerByDefectId(defectId);
    }
    public void createRepair(Repair repair) {
        // Убедитесь, что связанная сущность дефекта существует
        Defect defect = defectRepository.findById(repair.getDefect().getId())
                .orElseThrow(() -> new RuntimeException("Дефект не найден"));
        repair.setDefect(defect);

        // Убедитесь, что связанная сущность работника существует
        Worker worker = workerRepository.findById(repair.getWorker().getId())
                .orElseThrow(() -> new RuntimeException("Работник не найден"));
        repair.setWorker(worker);

        // Сохранение ремонта
        repairRepository.save(repair);
    }
}