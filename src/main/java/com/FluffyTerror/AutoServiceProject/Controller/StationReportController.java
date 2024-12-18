package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/station-report")
public class StationReportController {

    @Autowired
    private RepairService repairService;

    @GetMapping
    public String getReport(Model model) {
        model.addAttribute("report", repairService.getStationReport());
        return "station-report";
    }
}
