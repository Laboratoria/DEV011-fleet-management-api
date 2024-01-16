package com.example.dev011fleetmanagementapi.model.dao;

import com.example.dev011fleetmanagementapi.model.entity.Taxi;
import org.springframework.data.repository.CrudRepository;  //jpa repository
import org.springframework.data.repository.PagingAndSortingRepository;

//@repository
public interface TaxiRepository extends CrudRepository<Taxi, Integer> {
}
