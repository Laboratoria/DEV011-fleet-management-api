package com.fleetmanagementapi.api.services;

import com.fleetmanagementapi.api.model.entities.Taxi;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ITaxi {

    Page<Taxi> obtenerTodosLosTaxis(int page, int size);
}
