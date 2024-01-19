package com.fleetmanagementapi.api.services.impl;

import com.fleetmanagementapi.api.model.entities.Trajectory;
import com.fleetmanagementapi.api.model.repository.TrajectoryRepository;
import com.fleetmanagementapi.api.services.ITrajectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class TrajectoryImpl implements ITrajectory {

    @Autowired
    TrajectoryRepository trajectoryRepository;

    @Override
    public Page<Trajectory> listTrajectoriesById(Pageable pageable, Integer taxiId) {
        return this.trajectoryRepository.findByTaxiId(pageable, taxiId);
    }
}
