package com.FluffyTerror.AutoServiceProject.Repository;

import com.FluffyTerror.AutoServiceProject.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    // Поиск машин по ID владельца
    List<Car> findByOwnerId(Long ownerId);

    // Поиск всех номеров машин
    @Query("SELECT c.administrativeNumber FROM Car c")
    List<String> findAllCarNumbers();
}
