package com.FluffyTerror.AutoServiceProject.Repository;

import com.FluffyTerror.AutoServiceProject.Model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {

    @Query("SELECT w.fullName AS workerName, r.startTime, r.endTime " +
            "FROM Repair r JOIN r.worker w WHERE r.defect.defectId = :defectId")
    List<Object[]> findRepairWorkerByDefectId(@Param("defectId") Long defectId);
}
