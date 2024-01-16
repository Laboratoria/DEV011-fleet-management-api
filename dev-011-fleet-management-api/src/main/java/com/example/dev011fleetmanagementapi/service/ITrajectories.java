package com.example.dev011fleetmanagementapi.service;

import com.example.dev011fleetmanagementapi.model.entity.Taxi;
import com.example.dev011fleetmanagementapi.model.entity.Trajectories;

public interface ITrajectories {
    Trajectories save(Trajectories trajectories);
    Trajectories findById(Integer id);

    void delete (Trajectories trajectories);
    Trajectories update(Trajectories trajectories);
}
