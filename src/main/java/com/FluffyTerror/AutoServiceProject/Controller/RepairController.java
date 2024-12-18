package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Model.Repair;
import com.FluffyTerror.AutoServiceProject.Repository.WorkerRepository;
import com.FluffyTerror.AutoServiceProject.Service.DefectService;
import com.FluffyTerror.AutoServiceProject.Service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @Autowired
    private DefectService defectService;

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping("/create")
    public String showCreateRepairForm(Model model) {
        model.addAttribute("repair", new Repair());
        model.addAttribute("defects", defectService.getAllDefects());
        model.addAttribute("workers",workerRepository.findAll());
        return "create-repair";
    }

    @PostMapping("/create")
    public String createRepair(@ModelAttribute Repair repair) {
        repairService.createRepair(repair);
        return "redirect:/repair-worker";
    }
}