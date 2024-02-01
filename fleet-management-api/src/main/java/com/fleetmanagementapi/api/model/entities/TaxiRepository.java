package com.fleetmanagementapi.api.model.entities;

import com.fleetmanagementapi.api.model.repository.TaxiCrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class TaxiRepository implements TaxiCrudRepository {

    public Object findAll(Taxi taxi) {
        return null;
    }

    @Override
    public Iterable<Taxi> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Taxi> findAll(Pageable pageable) {
        return null;
    }
}
