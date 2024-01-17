package com.example.dev011fleetmanagementapi.service;


import com.example.dev011fleetmanagementapi.model.dto.TaxiDto;
import com.example.dev011fleetmanagementapi.model.entity.TaxiEntity;

public interface ITaxi {
    TaxiDto save(TaxiEntity taxiEntity);
    TaxiDto findById(Integer id);
    TaxiDto delete (Integer id) throws Exception;
    Iterable<TaxiEntity> findAll ();
    TaxiDto update(TaxiEntity taxiEntity);
}
