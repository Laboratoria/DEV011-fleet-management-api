package com.fleetmanagementapi.api.model.entities;

import com.fleetmanagementapi.api.model.repository.TaxiCrudRepository;

import java.util.List;

public class TaxiRepository {
    private TaxiCrudRepository taxiCrudRepository;

    public List<Taxi> getAll(){
        return (List<Taxi>) taxiCrudRepository.findAll();
    }
}
