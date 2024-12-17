package com.FluffyTerror.AutoServiceProject.Repository;


import com.FluffyTerror.AutoServiceProject.Model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Cars, Long> {

}