package com.fleetmanagementapi.api.controllers;

import com.fleetmanagementapi.api.model.entities.Taxi;
import com.fleetmanagementapi.api.services.ITaxi;
import com.fleetmanagementapi.api.services.impl.TaxiImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaxiController {

    @Autowired
    private ITaxi iTaxiService;

    @GetMapping("taxis")
    public Page<Taxi> obtenerTodosLosTaxis(@RequestParam Integer size, @RequestParam Integer nroPage) {
        PageRequest pageable = PageRequest.of(nroPage, size);
        return iTaxiService.obtenerTodosLosTaxis(pageable);
    }

}
