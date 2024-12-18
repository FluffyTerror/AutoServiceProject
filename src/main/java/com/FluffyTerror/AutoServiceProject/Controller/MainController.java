package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Service.CarOwnerService;
import com.FluffyTerror.AutoServiceProject.Service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @Autowired
    private CarOwnerService carOwnerService;

    @Autowired
    private RepairService repairService;

    // Главная страница
    @GetMapping("/")
    public String home() {
        return "menu";
    }
    @GetMapping("/exit")
    public String exit(){
        return "exit";
    }

}
