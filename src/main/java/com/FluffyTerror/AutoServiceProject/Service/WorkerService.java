package com.FluffyTerror.AutoServiceProject.Service;

import com.FluffyTerror.AutoServiceProject.Model.Worker;
import com.FluffyTerror.AutoServiceProject.Repository.WorkerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private RepairService repairService;

    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    public Worker getWorkerById(Long workerId) {
        return workerRepository.findById(workerId)
                .orElseThrow(() -> new EntityNotFoundException("Worker not found with id: " + workerId));
    }


    public void deleteWorkerById(Long workerId) {
        // Удалить все ремонты, связанные с работником
        repairService.deleteRepairsByWorkerId(workerId);

        // Удалить самого работника
        if (workerRepository.existsById(workerId)) {
            workerRepository.deleteById(workerId);
        } else {
            throw new IllegalArgumentException("Работник с ID " + workerId + " не найден.");
        }
    }
}
