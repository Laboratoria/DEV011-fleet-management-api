package com.example.dev011fleetmanagementapi.service.impl;

import com.example.dev011fleetmanagementapi.model.dao.TaxisRepository;
import com.example.dev011fleetmanagementapi.model.entity.TaxiEntity;
import com.example.dev011fleetmanagementapi.service.ITaxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Objects;

@Service
public class TaxiImpl implements ITaxi {


    @Autowired
    private TaxisRepository taxisRepository;
    //private TaxiEntity taxiDto;

    @Transactional(readOnly = true)
    @Override
    public Iterable<TaxiEntity> findAll() {
        return taxisRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public TaxiEntity findById(Integer id) throws SQLException {
        TaxiEntity taxiDB = taxisRepository.findById(id).orElse(null);
        if (Objects.isNull(taxiDB)){
            throw new SQLException("No existe un Taxi con ese ID");
        } else {
            return new TaxiEntity(taxiDB.getId(), taxiDB.getPlate());
        }
    }

    @Transactional
    @Override
    public TaxiEntity save(TaxiEntity taxiEntity) throws SQLException {
        if (Objects.isNull(taxiEntity)){
            throw new SQLException("No se puede guardar un taxi sin información");
        } else if (Objects.isNull(taxiEntity.getPlate()) | taxiEntity.getPlate() ==""){
            throw new SQLException("Falta información de atributo: 'plate'");
        } else if (taxiEntity.getPlate().length() != 9){
            throw new SQLException("'plate' debe tener una longitud de 9 (ejemplo: XXXX-0000 )");
        } else {
            taxisRepository.save(taxiEntity);
            return new TaxiEntity(taxiEntity.getId(),taxiEntity.getPlate());
        }
    }

    @Transactional
    @Override
    public TaxiEntity update(TaxiEntity taxiEntity, Integer id) throws DataAccessException, SQLException {
        TaxiEntity taxiToUpdate = findById(id);
        System.out.println("-------entra a update");
        System.out.println(taxiToUpdate);
        if (Objects.isNull(taxiToUpdate)){
            System.out.println("-------No existe un taxi con ese ID");
            throw new DataAccessException("No existe un taxi con ese ID") {
            };
        } else if (!Objects.equals(taxiEntity.getId(), taxiToUpdate.getId())) {
            System.out.println("-------No puede modificar el ID del taxi");
            throw new DataAccessException("No puede modificar el ID del taxi"){};
        } else if (Objects.isNull(taxiEntity.getPlate()) | taxiEntity.getPlate() ==""){
            throw new SQLException("Falta información de atributo: 'plate'");
        } else if (taxiEntity.getPlate().length() != 9){
            throw new SQLException("'plate' debe tener una longitud de 9 (ejemplo: XXXX-0000 )");
        } else {

            System.out.println("-------entra a else");
            taxisRepository.save(taxiEntity);
            return new TaxiEntity(taxiEntity.getId(),taxiEntity.getPlate());
        }
    }

    @Transactional
    @Override
    public TaxiEntity delete(Integer id) throws SQLException {
        TaxiEntity taxiDB = taxisRepository.findById(id).orElse(null);
        if (Objects.nonNull(taxiDB)) {
            TaxiEntity taxiDtoToDelete = findById(id);
            taxisRepository.delete(taxiDB);
            return taxiDtoToDelete;
        } else {
            throw new SQLException("No existe un Taxi con ese ID");
        }
    }
}
