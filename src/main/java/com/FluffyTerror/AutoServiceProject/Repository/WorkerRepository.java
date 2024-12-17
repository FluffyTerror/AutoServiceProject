package com.FluffyTerror.AutoServiceProject.Repository;

import com.FluffyTerror.AutoServiceProject.Model.Workers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Workers, Long> {

}
