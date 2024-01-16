package com.example.dev011fleetmanagementapi.service.impl;

import com.example.dev011fleetmanagementapi.model.dao.TaxiRepository;
import com.example.dev011fleetmanagementapi.model.entity.Taxi;
import com.example.dev011fleetmanagementapi.service.ITaxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaxiImpl implements ITaxi {
    @Autowired
    private TaxiRepository taxiRepository;

    @Transactional
    @Override
    public Taxi save(Taxi taxi) {
        return taxiRepository.save(taxi);
    }

    @Transactional(readOnly = true)
    @Override
    public Taxi findById(Integer id) {
        return taxiRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Taxi taxi) {
        taxiRepository.delete(taxi);
    }

    @Transactional
    @Override
    public Taxi update(Taxi taxi) {
        return taxiRepository.save(taxi);
    }


}
