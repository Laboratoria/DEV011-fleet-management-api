package com.example.dev011fleetmanagementapi.service;

import com.example.dev011fleetmanagementapi.model.entity.TrajectoryEntity;

public interface ITrajectory {
    TrajectoryEntity save(TrajectoryEntity trajectory);
    TrajectoryEntity findById(Integer id);

    void delete (TrajectoryEntity trajectory);
    TrajectoryEntity update(TrajectoryEntity trajectory);
}
