package com.fleetmanagementapi.api.services.impl;

import com.fleetmanagementapi.api.model.entities.Taxi;
import com.fleetmanagementapi.api.model.repository.TaxiRepositoryJPA;
import com.fleetmanagementapi.api.services.ITaxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class TaxiImpl implements ITaxi {

    @Autowired
    private TaxiRepositoryJPA taxiRepository;

    @Override
    public Page<Taxi> findAllTaxis(Pageable pageable) {
        return taxiRepository.findAll(pageable);
    }

    @Override
    public Taxi save(Taxi taxi) {
        return taxiRepository.save(taxi);
    }

    @Override
    public void delete(Integer id) {
        taxiRepository.deleteById(id);
    }

    @Override
    public boolean existTaxi(Integer id) {
        return taxiRepository.existsById(id);
    }
}
