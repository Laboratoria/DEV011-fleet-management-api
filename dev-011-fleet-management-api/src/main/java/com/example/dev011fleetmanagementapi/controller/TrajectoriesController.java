package com.example.dev011fleetmanagementapi.controller;

import com.example.dev011fleetmanagementapi.model.entity.Trajectories;
import com.example.dev011fleetmanagementapi.service.ITrajectories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class TrajectoriesController {

    @Autowired
    private ITrajectories iTrajectoriesService;

    @PostMapping("trajectory")
    public Trajectories create(@RequestBody Trajectories trajectories){
        return iTrajectoriesService.save(trajectories);
    }
    @PutMapping("trajectory")
    public Trajectories update(@RequestBody Trajectories trajectories){
        return iTrajectoriesService.update(trajectories);
    }

    @DeleteMapping("trajectory/{id}")
    public void delete(@PathVariable Integer id){
        Trajectories trajectoriesToDelete = iTrajectoriesService.findById(id);
        iTrajectoriesService.delete(trajectoriesToDelete);
    }

    @GetMapping("trajectory/{id}")
    public Trajectories getById(@PathVariable Integer id){
        return iTrajectoriesService.findById(id);
    }
}
