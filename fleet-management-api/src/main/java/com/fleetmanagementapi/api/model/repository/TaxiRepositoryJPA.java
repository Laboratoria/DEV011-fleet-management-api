package com.fleetmanagementapi.api.model.repository;

import com.fleetmanagementapi.api.model.entities.Taxi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiRepositoryJPA extends JpaRepository<Taxi, Integer> {


    //public Page<Taxi> findAllTaxis(Pageable pageable);

}
