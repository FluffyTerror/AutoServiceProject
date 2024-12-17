package com.FluffyTerror.AutoServiceProject.Repository;

import com.FluffyTerror.AutoServiceProject.Model.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {

    @Query("SELECT o.fullName AS ownerName, c.administrativeNumber AS licensePlate, c.brand AS carBrand, " +
            "c.manufacturer AS manufacturer, c.manufactureYear AS manufactureYear, d.description AS defectDescription, " +
            "CASE WHEN d.resolved = true THEN 'Resolved' ELSE 'Not Resolved' END AS defectStatus " +
            "FROM CarOwner o " +
            "JOIN o.cars c " +
            "JOIN c.defects d " +
            "WHERE o.fullName = :ownerName")
    List<Object[]> findCarDefectsByOwner(@Param("ownerName") String ownerName);

    @Query("SELECT o.fullName, o.address " +
            "FROM CarOwner o JOIN o.cars c " +
            "WHERE c.administrativeNumber = :adminNumber")
    Optional<Object[]> findOwnerInfoByCarNumber(@Param("adminNumber") String adminNumber);
}
