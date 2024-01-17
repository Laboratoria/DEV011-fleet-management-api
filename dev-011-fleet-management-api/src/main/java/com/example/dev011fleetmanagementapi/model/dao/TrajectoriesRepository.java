package com.example.dev011fleetmanagementapi.model.dao;

import com.example.dev011fleetmanagementapi.model.entity.TrajectoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface TrajectoriesRepository extends CrudRepository<TrajectoryEntity, Integer> {
}
