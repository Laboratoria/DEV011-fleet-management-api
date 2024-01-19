package com.example.dev011fleetmanagementapi.controller;

import com.example.dev011fleetmanagementapi.model.entity.TaxiEntity;
import com.example.dev011fleetmanagementapi.model.entity.TrajectoryEntity;
import com.example.dev011fleetmanagementapi.service.ITaxi;
import com.example.dev011fleetmanagementapi.service.ITrajectory;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1")
public class TrajectoriesController {

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="")

    @Autowired
    private ITrajectory iTrajectoriesService;

    @Autowired
    private ITaxi iTaxiService;

    @GetMapping("trajectories/{id}/{page}/{sizePage}")
    public Object getAll(@PathVariable Integer id, @PathVariable Integer page, @PathVariable Integer sizePage) throws SQLException {

        TaxiEntity taxi = iTaxiService.findById(id);
        if (taxi != null) {
            Iterable<TrajectoryEntity> trajectories = iTrajectoriesService.getAllByTaxi(taxi, page, sizePage);
            // Ahora 'trajectories' contiene todas las instancias de TrajectoryEntity asociadas con el taxi especificado.
            return trajectories;
        }
        return null;

    }

    @GetMapping("trajectory/{id}")
    public TrajectoryEntity getById(@PathVariable Integer id){
        return iTrajectoriesService.findById(id);
    }

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
}
