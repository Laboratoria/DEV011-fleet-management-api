package com.example.dev011fleetmanagementapi.controller;

import com.example.dev011fleetmanagementapi.model.entity.Taxi;
import com.example.dev011fleetmanagementapi.service.ITaxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class TaxiController {

    @Autowired
    private ITaxi iTaxiService;

    @PostMapping("taxi")
    public Taxi create(@RequestBody Taxi taxi){
        return iTaxiService.save(taxi);
    }
    @PutMapping("taxi")
    public Taxi update(@RequestBody Taxi taxi){
        return iTaxiService.update(taxi);
    }

    @DeleteMapping("taxi/{id}")
    public void delete(@PathVariable Integer id){
        Taxi taxiToDelete = iTaxiService.findById(id);
        iTaxiService.delete(taxiToDelete);
    }

    @GetMapping("taxi/{id}")
    public Taxi getById(@PathVariable Integer id){
        return iTaxiService.findById(id);
    }
}
