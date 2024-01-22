package com.fleetmanagementapi.api.controllers;


import com.fleetmanagementapi.api.model.entities.Trajectory;
import com.fleetmanagementapi.api.services.ITrajectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/trajectories")
public class TrajectoryController {
    @Autowired
    private ITrajectory iTrajectory;

    @GetMapping()
    public Page<Trajectory> getTrajectoriesByTaxiId(@RequestParam Integer taxiId, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date){
        PageRequest pageable = PageRequest.of(2, 2);
        return this.iTrajectory.listTrajectoriesById(pageable, taxiId, date);
    }

}
