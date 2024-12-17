package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Model.Car;
import com.FluffyTerror.AutoServiceProject.Model.CarOwner;
import com.FluffyTerror.AutoServiceProject.Repository.CarOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return "car-owners"; // Ожидается car-owners.html
    }

    @GetMapping("/add")
    public String showAddCarOwnerForm(Model model) {
        model.addAttribute("carOwner", new CarOwner());
        return "add-car-owner"; // Шаблон HTML
    }

    @PostMapping("/add")
    public String addCarOwner(@ModelAttribute("carOwner") CarOwner carOwner) {
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
