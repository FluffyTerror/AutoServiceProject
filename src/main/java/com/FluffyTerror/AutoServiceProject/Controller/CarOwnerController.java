package com.FluffyTerror.AutoServiceProject.Controller;

import java.util.List;

import com.FluffyTerror.AutoServiceProject.Model.CarOwner;
import com.FluffyTerror.AutoServiceProject.Repository.CarOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/car-owners")
public class CarOwnerController {

    @Autowired
    private CarOwnerRepository carOwnerRepository;

    // Получение всех владельцев
    @GetMapping
    public String listCarOwners(Model model) {
        List<CarOwner> carOwners = carOwnerRepository.findAll();
        model.addAttribute("carOwners", carOwners);
        return "car-owners"; // Переход к car-owners.html
    }

    // Страница для добавления нового владельца
    @GetMapping("/add")
    public String showAddCarOwnerForm(Model model) {
        model.addAttribute("carOwner", new CarOwner());
        return "add-car-owner"; // Переход к add-car-owner.html
    }

    // Обработка формы добавления владельца
    @PostMapping("/add")
    public String addCarOwner(@ModelAttribute CarOwner carOwner) {
        carOwnerRepository.save(carOwner);
        return "redirect:/car-owners";
    }

    // Удаление владельца
    @GetMapping("/delete/{id}")
    public String deleteCarOwner(@PathVariable Long id) {
        carOwnerRepository.deleteById(id);
        return "redirect:/car-owners";
    }
}
