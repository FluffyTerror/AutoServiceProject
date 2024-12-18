package com.FluffyTerror.AutoServiceProject.Repository;

import com.FluffyTerror.AutoServiceProject.Model.Defect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DefectRepository extends JpaRepository<Defect, Long> {

    @Query("SELECT d.description " +
            "FROM Defect d " +
            "JOIN d.car c " +
            "JOIN c.owner o " +
            "WHERE o.fullName = :ownerName AND d.resolved = true")
    List<String> findResolvedDefectsByOwner(@Param("ownerName") String ownerName);
    List<Defect> findByCar_CarIdAndResolvedTrue(Long carId);

    @Query("SELECT d.car.owner.fullName FROM Defect d WHERE d.description = :description")
    List<String> findOwnersByDefectDescription(@Param("description") String description);
    @Query("SELECT o.fullName FROM CarOwner o JOIN o.cars c JOIN c.defects d WHERE d.id = :defectId")
    List<String> findOwnersByDefectId(@Param("defectId") Long defectId);
}
