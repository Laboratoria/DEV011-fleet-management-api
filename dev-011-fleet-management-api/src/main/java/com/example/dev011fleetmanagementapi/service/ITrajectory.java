package com.example.dev011fleetmanagementapi.service;

import com.example.dev011fleetmanagementapi.model.entity.TaxiEntity;
import com.example.dev011fleetmanagementapi.model.entity.TrajectoryEntity;
import org.springframework.transaction.annotation.Transactional;

public interface ITrajectory {

    @Transactional(readOnly = true)
    Iterable<TrajectoryEntity> getAllByTaxi(TaxiEntity taxi);

    TrajectoryEntity save(TrajectoryEntity trajectory);
    TrajectoryEntity findById(Integer id);
    Iterable<TrajectoryEntity> findAll(Integer offSet, Integer pageSize);

    void delete (TrajectoryEntity trajectory);
    TrajectoryEntity update(TrajectoryEntity trajectory);
}
