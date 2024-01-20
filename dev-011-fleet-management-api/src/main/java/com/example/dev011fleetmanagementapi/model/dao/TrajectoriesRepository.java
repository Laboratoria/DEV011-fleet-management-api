package com.example.dev011fleetmanagementapi.model.dao;

import com.example.dev011fleetmanagementapi.model.entity.TaxiEntity;
import com.example.dev011fleetmanagementapi.model.entity.TrajectoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrajectoriesRepository extends JpaRepository<TrajectoryEntity, Integer> {
    Page<TrajectoryEntity> findByTaxi(TaxiEntity taxi, Pageable pageable);
    List<TrajectoryEntity> findByTaxi(TaxiEntity taxi);
}
