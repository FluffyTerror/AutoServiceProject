package com.FluffyTerror.AutoServiceProject.Repository;

import com.FluffyTerror.AutoServiceProject.Model.Car;
import com.FluffyTerror.AutoServiceProject.Model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {

    Optional<Repair> findByDefectId(Long defectId);
    @Query("SELECT w.fullName AS workerName, r.startTime, r.endTime " +
            "FROM Repair r JOIN r.worker w WHERE r.defect.id = :defectId")
    List<Object[]> findRepairWorkerByDefectId(@Param("defectId") Long defectId);

    @Query("SELECT r.worker.fullName, r.defect.car.brand, COUNT(r.defect.car), SUM(TIMESTAMPDIFF(MINUTE, r.startTime, r.endTime)),r.defect.description " +
            "FROM Repair r " +
            "GROUP BY r.worker.fullName, r.defect.car.brand,r.defect.description")
    List<Object[]> getRepairReport();

    @Query("SELECT r.defect.car FROM Repair r WHERE r.worker.id = :workerId")
    List<Car> findCarsRepairedByWorker(@Param("workerId") Long workerId);

    List<Repair> findByWorkerId(Long workerId);

}
