package com.FluffyTerror.AutoServiceProject.Repository;

import com.FluffyTerror.AutoServiceProject.Model.Defects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DefectRepository extends JpaRepository<Defects, Long> {

    @Query("SELECT d.description" +
            "FROM Defects d" +
            "JOIN Cars c ON d.car_id = c.car_id" +
            "JOIN Car_owner o ON c.owner_id = o.owner_id" +
            "WHERE o.full_name = :ownerName AND d.resolved = :TRUE")
    List<String> findResolvedDefectsByOwner(@Param("ownerName") String ownerName);
}
