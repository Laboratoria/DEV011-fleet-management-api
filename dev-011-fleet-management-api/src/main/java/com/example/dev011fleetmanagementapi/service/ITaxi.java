package com.example.dev011fleetmanagementapi.service;

import com.example.dev011fleetmanagementapi.model.entity.Taxi;

public interface ITaxi {
    Taxi save(Taxi taxi);
    Taxi findById(Integer id);
    void delete (Taxi taxi);
    Taxi update(Taxi taxi);
}
