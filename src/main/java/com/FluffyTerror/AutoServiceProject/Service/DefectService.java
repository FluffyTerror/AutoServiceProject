package com.FluffyTerror.AutoServiceProject.Service;

import com.FluffyTerror.AutoServiceProject.Model.Defect;
import com.FluffyTerror.AutoServiceProject.Repository.DefectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefectService {

    @Autowired
    private DefectRepository defectRepository;

    // Получить все дефекты
    public List<Defect> getAllDefects() {
        return defectRepository.findAll();
    }
}