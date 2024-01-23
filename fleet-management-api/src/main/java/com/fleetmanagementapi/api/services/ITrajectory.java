package com.fleetmanagementapi.api.services;

import com.fleetmanagementapi.api.model.entities.Taxi;
import com.fleetmanagementapi.api.model.entities.Trajectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface ITrajectory {

    Page<Trajectory> listTrajectoriesById(Integer taxiId, Date date, Pageable pageable );

}
