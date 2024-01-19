package com.fleetmanagementapi.api.services;

import com.fleetmanagementapi.api.model.entities.Taxi;
import com.fleetmanagementapi.api.model.entities.Trajectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITrajectory {

    Page<Trajectory> listTrajectoriesById(Pageable pageable, Integer taxiId);

}
