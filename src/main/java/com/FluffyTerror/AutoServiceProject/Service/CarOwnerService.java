package com.FluffyTerror.AutoServiceProject.Service;

import com.FluffyTerror.AutoServiceProject.Model.Car;
import com.FluffyTerror.AutoServiceProject.Model.CarOwner;
import com.FluffyTerror.AutoServiceProject.Model.Defect;
import com.FluffyTerror.AutoServiceProject.Repository.CarOwnerRepository;
import com.FluffyTerror.AutoServiceProject.Repository.CarRepository;
import com.FluffyTerror.AutoServiceProject.Repository.DefectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarOwnerService {
    @Autowired
    private CarOwnerRepository carOwnerRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DefectRepository defectRepository;

    // Получить всех владельцев
    public List<CarOwner> getAllCarOwners() {
        return carOwnerRepository.findAll();
    }

    // Получить все машины конкретного владельца
    public List<Car> getCarsByOwner(Long ownerId) {
        return carRepository.findByOwnerId(ownerId);
    }

    // Получить все устраненные дефекты машины
    public List<Defect> getResolvedDefectsByCar(Long carId) {
        return defectRepository.findByCar_CarIdAndResolvedTrue(carId);
    }

    // Получить все номера автомобилей
    public List<String> getAllCarNumbers() {
        return carRepository.findAllCarNumbers();
    }

    public List<Object[]> getCarDefectsByOwner(String ownerName) {
        return carOwnerRepository.findCarDefectsByOwner(ownerName);
    }

    public Optional<Object[]> getOwnerInfoByCarNumber(String adminNumber) {
        return carOwnerRepository.findOwnerInfoByCarNumber(adminNumber);
    }
}

