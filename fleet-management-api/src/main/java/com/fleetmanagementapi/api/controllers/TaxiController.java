package com.fleetmanagementapi.api.controllers;

import com.fleetmanagementapi.api.model.entities.Taxi;
import com.fleetmanagementapi.api.services.ITaxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class TaxiController {
//
    @Autowired
    private ITaxi iTaxiService;

    @PostMapping("postTaxi")
    public Taxi saveTaxi(@RequestBody Taxi taxi){
        return iTaxiService.save(taxi);
    }

    @GetMapping("getTaxis")
    public Page<Taxi> findAllTaxis(@RequestParam Integer size, @RequestParam Integer nroPage) {
        PageRequest pageable = PageRequest.of(nroPage, size);
        return iTaxiService.findAllTaxis(pageable);
    }
    
    @PutMapping("putTaxi")
    public Taxi updateTaxi(@RequestBody Taxi taxi){
        return iTaxiService.save(taxi);
    }

    @DeleteMapping("deleteTaxiById")
    public void deleteTaxiByid(@RequestParam Integer id){
        iTaxiService.delete(id);
    }






}
