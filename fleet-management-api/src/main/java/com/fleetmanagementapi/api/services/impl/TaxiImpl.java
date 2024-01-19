package com.fleetmanagementapi.api.services.impl;

import com.fleetmanagementapi.api.model.entities.Taxi;
import com.fleetmanagementapi.api.model.entities.TaxiRepository;
import com.fleetmanagementapi.api.model.repository.TaxiCrudRepository;
import com.fleetmanagementapi.api.services.ITaxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.util.List;

@Service
public class TaxiImpl implements ITaxi {

    @Autowired
    private TaxiRepository taxiRepository;

    @Override
    public Page<Taxi> obtenerTodosLosTaxis(@RequestParam int page, @RequestParam int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return taxiRepository.findAll(pageable);
    }
}
