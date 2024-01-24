package com.fleetmanagementapi.api.controllers;

import com.fleetmanagementapi.api.model.entities.Trajectory;
import com.fleetmanagementapi.api.services.ILastTrayectoryByIdTaxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lasttrajectory")
public class LastTrajectoryByIdTaxiController {
@Autowired
    private ILastTrayectoryByIdTaxi iLastTrayectoryByIdTaxi;

@GetMapping()
    public List<Trajectory> getLastTrayectoryByTaxiId(
            @RequestParam Integer taxiId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size
){
    //PageRequest pageable = PageRequest.of(page, size);
    return iLastTrayectoryByIdTaxi.findTrajectoryByTaxiId( taxiId);
}
}
