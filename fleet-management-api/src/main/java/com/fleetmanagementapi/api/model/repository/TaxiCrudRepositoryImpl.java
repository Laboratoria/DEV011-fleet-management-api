package com.fleetmanagementapi.api.model.repository;

import com.fleetmanagementapi.api.model.entities.Taxi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class TaxiCrudRepositoryImpl implements TaxiCrudRepository {
    @Override
    public Iterable<Taxi> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Taxi> findAll(Pageable pageable) {
        return null;
    }
}
