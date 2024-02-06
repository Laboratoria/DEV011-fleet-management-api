package com.fleetmanagementapi.api.model.repository;

import com.fleetmanagementapi.api.model.entities.Trajectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TrajectoryRepository  extends JpaRepository<Trajectory, Integer> {

    //Page<Trajectory> findByTaxiIdAndDate(Integer taxiId, Date date, Pageable pageable);
    //nueva consulta
    @Query(value = "SELECT * FROM public.trajectories WHERE taxi_id = ?1 AND Date(date) = ?2", nativeQuery = true)
    Page<Trajectory> findByTaxiIdAndDate(Integer taxiId, Date date, Pageable pageable);

    @Query(value = "SELECT * FROM public.trajectories WHERE taxi_id = ?1 ORDER BY date LIMIT 1", nativeQuery = true)
    List<Trajectory> findLastTrajectory(Integer taxiId);
}
