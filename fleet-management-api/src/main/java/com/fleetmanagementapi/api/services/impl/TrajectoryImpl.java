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
    public Trajectory saveTrajectory(Trajectory trajectory) {
        return trajectoryRepository.save(trajectory);
    }

    @Override
    public void deleteTrajectory(Integer id) {
        trajectoryRepository.deleteById(id);
    }

    @Override
    public Page<Trajectory> listTrajectoriesById(Integer taxiId, Date date, Pageable pageable) {
        return trajectoryRepository.findByTaxiIdAndDate(taxiId, date, pageable);
    }

    @Override
    public boolean existId(Integer id) {
        return trajectoryRepository.existsById(id);

    }
}
