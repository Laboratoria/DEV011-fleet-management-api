package com.fleetmanagementapi.api.controllers;


import com.fleetmanagementapi.api.model.entities.Trajectory;
import com.fleetmanagementapi.api.services.ITrajectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> deleteTrajectory(@RequestParam Integer id){
        if(iTrajectory.existId(id)){
        iTrajectory.deleteTrajectory(id);
        return ResponseEntity.noContent().build();
        }
        else{
            String mensajeError = "La trajectoria con el ID " + id + " no existe.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }
}
