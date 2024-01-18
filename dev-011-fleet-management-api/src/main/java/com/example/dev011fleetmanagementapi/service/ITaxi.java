package com.example.dev011fleetmanagementapi.service;


import com.example.dev011fleetmanagementapi.model.entity.TaxiEntity;

import java.sql.SQLException;

public interface ITaxi {
    TaxiEntity save(TaxiEntity taxiEntity) throws SQLException;
    TaxiEntity findById(Integer id) throws SQLException;
    TaxiEntity delete (Integer id) throws Exception;
    Iterable<TaxiEntity> findAll ();
    TaxiEntity update(TaxiEntity taxiEntity, Integer id) throws org.springframework.dao.DataAccessException, SQLException;
}
