package com.FluffyTerror.AutoServiceProject.Service;

import com.FluffyTerror.AutoServiceProject.Model.Car;
import com.FluffyTerror.AutoServiceProject.Model.Defect;
import com.FluffyTerror.AutoServiceProject.Model.Repair;
import com.FluffyTerror.AutoServiceProject.Model.Worker;
import com.FluffyTerror.AutoServiceProject.Repository.DefectRepository;
import com.FluffyTerror.AutoServiceProject.Repository.RepairRepository;
import com.FluffyTerror.AutoServiceProject.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RepairService {
    @Autowired
    private RepairRepository repairRepository;
    @Autowired
    private DefectRepository defectRepository;

    @Autowired
    private WorkerRepository workerRepository;

    public List<Repair> getRepairsByWorkerId(Long workerId) {
        return repairRepository.findByWorkerId(workerId);
    }

    public List<Car> getCarsRepairedByWorker(Long workerId) {
        return repairRepository.findCarsRepairedByWorker(workerId);
    }

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
    public List<Map<String, Object>> getStationReport(){
        List<Object[]> rawData = repairRepository.getRepairReport();
        List<Map<String, Object>> report = new ArrayList<>();

        for (Object[] row : rawData) {
            Map<String, Object> reportEntry = new HashMap<>();
            reportEntry.put("workerName", row[0]);
            reportEntry.put("carBrand", row[1]);
            reportEntry.put("carCount", row[2]);
            reportEntry.put("repairTime", row[3]);
            reportEntry.put("defect", row[4]);
            report.add(reportEntry);
        }

        return report;
    }


    public void deleteRepairsByWorkerId(Long workerId) {
        repairRepository.deleteByWorkerId(workerId);
    }
}
