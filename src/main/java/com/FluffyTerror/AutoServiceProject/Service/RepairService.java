package com.FluffyTerror.AutoServiceProject.Service;

import com.FluffyTerror.AutoServiceProject.Repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {
    @Autowired
    private RepairRepository repairRepository;

    public List<Object[]> getRepairWorkerByDefectId(Long defectId) {
        return repairRepository.findRepairWorkerByDefectId(defectId);
    }
}