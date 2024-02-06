package com.fleetmanagementapi.api.controllers;


import com.fleetmanagementapi.api.model.entities.Trajectory;
import com.fleetmanagementapi.api.services.ITrajectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/")
public class TrajectoryController {
    @Autowired
    private ITrajectory iTrajectory;


    @PostMapping("postTrajectory")
    public Trajectory saveTrajectory(@RequestBody Trajectory trajectory){
        return iTrajectory.saveTrajectory(trajectory);
    }

    @PutMapping("putTrajectory")
    public Trajectory UpdateTrajectory(@RequestBody Trajectory trajectory){
        return iTrajectory.saveTrajectory(trajectory);
    }


    @GetMapping("getTrajectory")
    public Page<Trajectory> getTrajectoriesByTaxiId(
            @RequestParam Integer taxiId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size
    ){
        PageRequest pageable = PageRequest.of(page, size);
        return iTrajectory.listTrajectoriesById(taxiId, date, pageable);
    }

    @DeleteMapping("deleteTrajectory")
    public void deleteTrajectory(@RequestParam Integer id){
        iTrajectory.deleteTrajectory(id);
    }
}
