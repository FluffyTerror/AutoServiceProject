package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Service.CarOwnerService;
import com.FluffyTerror.AutoServiceProject.Service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @Autowired
    private CarOwnerService carOwnerService;

    @Autowired
    private RepairService repairService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/view-car-defects")
    public String viewCarDefects(@RequestParam("ownerName") String ownerName, Model model) {
        model.addAttribute("defects", carOwnerService.getCarDefectsByOwner(ownerName));
        return "car_defects";
    }

    @GetMapping("/owner-info")
    public String getOwnerInfo(@RequestParam("carNumber") String carNumber, Model model) {
        model.addAttribute("owner", carOwnerService.getOwnerInfoByCarNumber(carNumber));
        return "owner_info";
    }

    @GetMapping("/repair-worker")
    public String getRepairWorker(@RequestParam("defectId") Long defectId, Model model) {
        model.addAttribute("workers", repairService.getRepairWorkerByDefectId(defectId));
        return "repair_worker";
    }
}