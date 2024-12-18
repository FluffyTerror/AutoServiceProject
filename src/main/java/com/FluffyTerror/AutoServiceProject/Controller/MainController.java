package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Service.CarOwnerService;
import com.FluffyTerror.AutoServiceProject.Service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private CarOwnerService carOwnerService;

    @Autowired
    private RepairService repairService;

    // Главная страница
    @GetMapping("/")
    public String home() {
        return "menu"; // Ожидается menu.html
    }




}
