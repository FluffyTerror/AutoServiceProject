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
}
