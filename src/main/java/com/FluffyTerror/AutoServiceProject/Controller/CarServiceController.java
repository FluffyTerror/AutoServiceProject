package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Model.CarOwner;
import com.FluffyTerror.AutoServiceProject.Repository.CarOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/car-services")
public class CarServiceController {

    @Autowired
    private CarOwnerRepository carOwnerRepository;

    // Получение всех владельцев
    @GetMapping("/owners")
    public List<CarOwner> getAllCarOwners() {
        return carOwnerRepository.findAll();
    }

    // Добавление нового владельца
    @PostMapping("/add")
    public CarOwner addCarOwner(@RequestBody CarOwner carOwner) {
        return carOwnerRepository.save(carOwner);
    }

    // Удаление владельца
    @DeleteMapping("/{id}")
    public void deleteCarOwner(@PathVariable Long id) {
        carOwnerRepository.deleteById(id);
    }

}
