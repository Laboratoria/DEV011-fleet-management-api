package com.example.dev011fleetmanagementapi.service;


import com.example.dev011fleetmanagementapi.model.entity.TaxiEntity;

import java.sql.SQLException;

public interface ITaxi {
    TaxiEntity saveTaxi(TaxiEntity taxiEntity) throws SQLException;
    TaxiEntity findTaxiById(Integer id) throws SQLException;
    TaxiEntity deleteTaxi (Integer id) throws Exception;
    Iterable<TaxiEntity> findAllTaxis (Integer page, Integer pageSize);
    TaxiEntity updateTaxi(TaxiEntity taxiEntity, Integer id) throws org.springframework.dao.DataAccessException, SQLException;
}
