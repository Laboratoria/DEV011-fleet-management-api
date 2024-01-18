package com.example.dev011fleetmanagementapi.model.dao;

import com.example.dev011fleetmanagementapi.model.entity.TaxiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;  //jpa repository



//@repository
public interface TaxisRepository extends JpaRepository<TaxiEntity, Integer> {
}
