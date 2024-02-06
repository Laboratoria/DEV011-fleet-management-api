package com.fleetmanagementapi.api.services;

import com.fleetmanagementapi.api.model.entities.Taxi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITaxi {

    Page<Taxi> findAllTaxis(Pageable pageable);

    Taxi save (Taxi taxi);

    void delete(Integer id);

    boolean existTaxi(Integer id);



}
