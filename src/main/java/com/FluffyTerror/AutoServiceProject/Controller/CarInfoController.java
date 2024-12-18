package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Repository.CarOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/car-info")
public class CarInfoController {

    @Autowired
    private CarOwnerRepository carOwnerRepository;

    // Получение информации о машинах владельца
    @GetMapping("/{ownerName}")
    public List<Object[]> getCarInfoByOwner(@PathVariable String ownerName) {
        return carOwnerRepository.findCarsByOwnerName(ownerName);
    }
}