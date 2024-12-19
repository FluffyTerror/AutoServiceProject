package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Model.Car;
import com.FluffyTerror.AutoServiceProject.Model.CarOwner;
import com.FluffyTerror.AutoServiceProject.Repository.CarOwnerRepository;
import com.FluffyTerror.AutoServiceProject.Service.CarsService;
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
    @Autowired
    private CarsService carService;

    // Получение всех владельцев
    @GetMapping
    public String listCarOwners(Model model) {
        List<CarOwner> carOwners = carOwnerRepository.findAll();
        model.addAttribute("carOwners", carOwners);
        return "car-owners";
    }
    @GetMapping("/a")
    public String listCarOwnerss(Model model) {
        List<CarOwner> carOwners = carOwnerRepository.findAll();
        model.addAttribute("carOwners", carOwners);
        return "car-ownerss";
    }
    @GetMapping("/a/{ownerId}")
    public String getCarsByOwnerId(@PathVariable Long ownerId, Model model) {
        model.addAttribute("cars", carService.getCarsByOwnerId(ownerId));
        return "owner-cars"; // Шаблон Thymeleaf
    }

    @GetMapping("/add")
    public String showAddCarOwnerForm(Model model) {
        model.addAttribute("carOwner", new CarOwner());
        return "add-car-owner";
    }

    @PostMapping("/add")
    public String addCarOwner(@ModelAttribute("carOwner") CarOwner carOwner) {
        carOwnerRepository.save(carOwner);
        return "redirect:/car-owners";
    }

    @GetMapping("/delete/{id}")
    public String deleteCarOwner(@PathVariable Long id) {
        carOwnerRepository.deleteById(id);
        return "redirect:/car-owners";
    }
    @GetMapping("/update-registration")
    public String showCarOwnersForUpdate(Model model) {
        List<CarOwner> carOwners = carOwnerRepository.findAll();
        model.addAttribute("carOwners", carOwners);
        return "car-owners-update-list"; // Шаблон с выбором владельца
    }

    @GetMapping("/update-registration/{ownerId}")
    public String showUpdateRegistrationForm(@PathVariable Long ownerId, Model model) {
        CarOwner owner = carOwnerRepository.findById(ownerId).orElse(null);
        model.addAttribute("owner", owner);
        model.addAttribute("cars", carService.getCarsByOwnerId(ownerId));
        return "update-registration"; // Шаблон формы изменения номера
    }

    @PostMapping("/update-registration/{carId}")
    public String updateRegistrationNumber(@PathVariable Long carId, @RequestParam String newRegistrationNumber) {
        carService.updateCarRegistrationNumber(carId, newRegistrationNumber);
        return "redirect:/car-owners/update-registration";
    }
}
