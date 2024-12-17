package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Model.CarOwner;
import com.FluffyTerror.AutoServiceProject.Repository.CarOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/car-owners")
public class CarServiceController {

    @Autowired
    private CarOwnerRepository carOwnerRepository;

    // Получение всех владельцев
    @GetMapping
    public List<CarOwner> getAllCarOwners() {
        return carOwnerRepository.findAll();
    }

    // Получение владельца по номеру машины
    @GetMapping("/by-number/{number}")
    public Optional<Object[]> getCarOwnerByNumber(@PathVariable String number) {
        return carOwnerRepository.findOwnerInfoByCarNumber(number);
    }

    // Добавление нового владельца
    @PostMapping
    public CarOwner addCarOwner(@RequestBody CarOwner carOwner) {
        return carOwnerRepository.save(carOwner);
    }

    // Удаление владельца
    @DeleteMapping("/{id}")
    public void deleteCarOwner(@PathVariable Long id) {
        carOwnerRepository.deleteById(id);
    }
}
