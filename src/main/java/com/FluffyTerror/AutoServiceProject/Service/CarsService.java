package com.FluffyTerror.AutoServiceProject.Service;

import com.FluffyTerror.AutoServiceProject.Model.Car;
import com.FluffyTerror.AutoServiceProject.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getCarsByOwnerId(Long ownerId) {
        return carRepository.findCarsByOwnerId(ownerId);
    }
    /**
     * Обновление регистрационного номера автомобиля по ID
     * @param carId ID автомобиля
     * @param newRegistrationNumber Новый регистрационный номер
     */
    public void updateCarRegistrationNumber(Long carId, String newRegistrationNumber) {
        Car car = carRepository.findById(carId).orElseThrow(() ->
                new IllegalArgumentException("Автомобиль с ID " + carId + " не найден.")
        );
        car.setAdministrativeNumber(newRegistrationNumber);
        carRepository.save(car);
    }
}
