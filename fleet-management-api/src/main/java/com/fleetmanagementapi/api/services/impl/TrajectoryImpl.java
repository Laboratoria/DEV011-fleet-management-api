package com.fleetmanagementapi.api.services.impl;

import com.fleetmanagementapi.api.model.entities.Trajectory;
import com.fleetmanagementapi.api.model.repository.TrajectoryRepository;
import com.fleetmanagementapi.api.services.ITrajectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TrajectoryImpl implements ITrajectory {


    @Autowired
    TrajectoryRepository trajectoryRepository;

    @Override
    public Page<Trajectory> listTrajectoriesById(Integer taxiId, Date date, Pageable pageable) {
        return trajectoryRepository.findByTaxiIdAndDate(taxiId, date, pageable);
    }
}
