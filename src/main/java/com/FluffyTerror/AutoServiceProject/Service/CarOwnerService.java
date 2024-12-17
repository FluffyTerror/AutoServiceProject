package com.FluffyTerror.AutoServiceProject.Service;

import com.FluffyTerror.AutoServiceProject.Repository.CarOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarOwnerService {
    @Autowired
    private CarOwnerRepository carOwnerRepository;

    public List<Object[]> getCarDefectsByOwner(String ownerName) {
        return carOwnerRepository.findCarDefectsByOwner(ownerName);
    }

    public Optional<Object[]> getOwnerInfoByCarNumber(String adminNumber) {
        return carOwnerRepository.findOwnerInfoByCarNumber(adminNumber);
    }
}

