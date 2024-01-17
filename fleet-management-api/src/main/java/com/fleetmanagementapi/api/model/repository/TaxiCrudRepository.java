package com.fleetmanagementapi.api.model.repository;

import com.fleetmanagementapi.api.model.entities.Taxi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaxiCrudRepository extends PagingAndSortingRepository<Taxi, Integer> {

}
