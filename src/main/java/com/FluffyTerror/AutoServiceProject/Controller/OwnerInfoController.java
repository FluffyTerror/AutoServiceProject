package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Service.CarOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner-info")
public class OwnerInfoController {

    @Autowired
    private CarOwnerService carOwnerService;

    // Список всех госномеров
    @GetMapping
    public String listCarNumbers(Model model) {
        model.addAttribute("carNumbers", carOwnerService.getAllCarNumbers());
        return "owner-info-numbers"; // Шаблон для отображения номеров
    }

    // Информация о владельце по номеру машины
    @GetMapping("/{carNumber}")
    public String getOwnerInfo(@PathVariable String carNumber, Model model) {
        model.addAttribute("owner", carOwnerService.getOwnerInfoByCarNumber(carNumber));
        return "owner-info-details"; // Шаблон для отображения информации о владельце
    }
}
