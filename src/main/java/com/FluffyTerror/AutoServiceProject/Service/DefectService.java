package com.FluffyTerror.AutoServiceProject.Service;

import com.FluffyTerror.AutoServiceProject.Model.CarOwner;
import com.FluffyTerror.AutoServiceProject.Model.Defect;
import com.FluffyTerror.AutoServiceProject.Repository.CarOwnerRepository;
import com.FluffyTerror.AutoServiceProject.Repository.DefectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefectService {



    @Autowired
    private CarOwnerRepository ownerRepository;

    @Autowired
    private DefectRepository defectRepository;
    public List<CarOwner> getOwnersByDefectId(Long defectId) {
        return ownerRepository.findOwnersByDefectId(defectId);
    }
    public List<String> getOwnersByDefectDescription(String description) {
        return defectRepository.findOwnersByDefectDescription(description);
    }

    // Получить все дефекты
    public List<Defect> getAllDefects() {
        return defectRepository.findAll();
    }
}