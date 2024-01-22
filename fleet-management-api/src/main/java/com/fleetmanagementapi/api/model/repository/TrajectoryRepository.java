package com.fleetmanagementapi.api.model.repository;

import com.fleetmanagementapi.api.model.entities.Trajectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TrajectoryRepository  extends JpaRepository<Trajectory, Integer> {

    Page<Trajectory> findByTaxiIdAndDate(Pageable pageable, Integer taxiId, Date date);

}
