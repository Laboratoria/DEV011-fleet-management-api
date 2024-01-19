package com.example.dev011fleetmanagementapi.service;

import com.example.dev011fleetmanagementapi.model.entity.TaxiEntity;
import com.example.dev011fleetmanagementapi.model.entity.TrajectoryEntity;

import java.sql.SQLException;

public interface ITrajectory {

    Iterable<TrajectoryEntity> getAllTrajectories(Integer offSet, Integer pageSize);

    Iterable<TrajectoryEntity> getTrajectoriesByTaxi(TaxiEntity taxi, Integer page, Integer pageSize);

    TrajectoryEntity getOneTrajectoryById(Integer id) throws SQLException;

    TrajectoryEntity saveOneTrajectory(TrajectoryEntity trajectory) throws Exception;

    TrajectoryEntity updateOneTrajectory(TrajectoryEntity trajectory, Integer id) throws SQLException;
    TrajectoryEntity deleteOneTrajectoryById(Integer id) throws SQLException;

    Iterable<TrajectoryEntity> deleteTrajectoriesByTaxiId(Integer id) throws SQLException;
}
