package com.example.dev011fleetmanagementapi.controller;

import com.example.dev011fleetmanagementapi.model.entity.TrajectoryEntity;
import com.example.dev011fleetmanagementapi.service.ITrajectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TrajectoriesController {

    @Autowired
    private ITrajectory iTrajectoriesService;

    @PostMapping("trajectory")
    public TrajectoryEntity create(@RequestBody TrajectoryEntity trajectories){
        return iTrajectoriesService.save(trajectories);
    }
    @PutMapping("trajectory")
    public TrajectoryEntity update(@RequestBody TrajectoryEntity trajectories){
        return iTrajectoriesService.update(trajectories);
    }

    @DeleteMapping("trajectory/{id}")
    public void delete(@PathVariable Integer id){
        TrajectoryEntity trajectoriesToDelete = iTrajectoriesService.findById(id);
        iTrajectoriesService.delete(trajectoriesToDelete);
    }

    @GetMapping("trajectory/{id}")
    public TrajectoryEntity getById(@PathVariable Integer id){
        return iTrajectoriesService.findById(id);
    }
}
