package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Model.Car;
import com.FluffyTerror.AutoServiceProject.Model.CarOwner;
import com.FluffyTerror.AutoServiceProject.Repository.CarRepository;
import com.FluffyTerror.AutoServiceProject.Repository.CarOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarOwnerRepository ownerRepository;

    @GetMapping("/cars/add")
    public String showAddCarForm(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("owners", ownerRepository.findAll()); // Для выбора владельца авто
        return "add-car";
    }

    @PostMapping("/cars/add")
    public String addCar(@ModelAttribute("car") Car car, Model model) {
        carRepository.save(car);
        model.addAttribute("message", "Автомобиль успешно добавлен!");
        return "add-car";
    }
}