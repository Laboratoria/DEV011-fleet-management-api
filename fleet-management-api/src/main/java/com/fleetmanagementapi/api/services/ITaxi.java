package com.fleetmanagementapi.api.services;

import com.fleetmanagementapi.api.model.entities.Taxi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITaxi {

    Page<Taxi> obtenerTodosLosTaxis(Pageable pageable);
}
