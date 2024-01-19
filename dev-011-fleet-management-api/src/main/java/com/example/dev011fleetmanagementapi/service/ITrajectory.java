package com.example.dev011fleetmanagementapi.service;

import com.example.dev011fleetmanagementapi.model.entity.TaxiEntity;
import com.example.dev011fleetmanagementapi.model.entity.TrajectoryEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ITrajectory {

    @Transactional(readOnly = true)
    List<TrajectoryEntity> getAllByTaxi(TaxiEntity taxi, Integer page, Integer pageSize);

    TrajectoryEntity save(TrajectoryEntity trajectory);
    TrajectoryEntity findById(Integer id);
    Iterable<TrajectoryEntity> findAll(Integer offSet, Integer pageSize);

    void delete (TrajectoryEntity trajectory);
    TrajectoryEntity update(TrajectoryEntity trajectory);
}
