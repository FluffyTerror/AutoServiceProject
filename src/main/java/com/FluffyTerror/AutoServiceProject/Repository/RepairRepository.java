package com.FluffyTerror.AutoServiceProject.Repository;

import com.FluffyTerror.AutoServiceProject.Model.Repairs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repairs, Long> {

    @Query("SELECT w.fullName AS workerName, r.startTime, r.endTime " +
            "FROM Repairs r JOIN r.worker w WHERE r.defect.id = :defectId")
    List<Object[]> findRepairWorkerByDefectId(@Param("defectId") Long defectId);
}
