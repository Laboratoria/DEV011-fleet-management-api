package com.fleetmanagementapi.api.model.repository;

import com.fleetmanagementapi.api.model.entities.Taxi;
import org.springframework.data.repository.CrudRepository;

public interface TaxiCrudRepository extends CrudRepository<Taxi, Integer> {

}
