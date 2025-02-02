package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Service.DefectService;
import com.FluffyTerror.AutoServiceProject.Service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/repair-worker")
public class RepairWorkerController {

    @Autowired
    private RepairService repairService;

    @Autowired
    private DefectService defectService;

    // Вывод всех дефектов
    @GetMapping
    public String listDefects(Model model) {
        model.addAttribute("defects", defectService.getAllDefects());
        return "repair-worker-defects";
    }

    // Информация о рабочем по выбранному дефекту
    @GetMapping("/{defectId}")
    public String getRepairDetails(@PathVariable Long defectId, Model model) {
        model.addAttribute("repair", repairService.getRepairDetailsByDefectId(defectId));
        return "repair-worker-details";
    }
}
