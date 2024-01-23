package com.fleetmanagementapi.api.model.repository;

import com.fleetmanagementapi.api.model.DTO.LastTrayectoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LastTrayectoryByTaxiIdRepository extends JpaRepository<Object, Integer> {
    @Query("SELECT new com.example.LastTrayectoryDTO(taxis.id AS taxi_id, taxis.plate, " +
            "trajectories.date, trajectories.latitude, trajectories.longitude) " +
            "FROM Taxis taxis " +
            "LEFT JOIN Trajectories trajectories ON taxis.id = trajectories.taxi_id " +
            "WHERE taxis.id = :taxiId " +
            "ORDER BY trajectories.date DESC " +
            "LIMIT 1")
    Page<LastTrayectoryDTO> findTrayectoryByTaxiId(Pageable pageable, @Param("taxiId")  Integer taxiId);
}
