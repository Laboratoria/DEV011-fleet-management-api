package com.example.dev011fleetmanagementapi.service.impl;

import com.example.dev011fleetmanagementapi.model.dao.TaxisRepository;
import com.example.dev011fleetmanagementapi.model.dto.TaxiDto;
import com.example.dev011fleetmanagementapi.model.entity.TaxiEntity;
import com.example.dev011fleetmanagementapi.service.ITaxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class TaxiImpl implements ITaxi {


    @Autowired
    private TaxisRepository taxisRepository;
    //private TaxiDto taxiDto;
    @Transactional
    @Override
    public TaxiDto save(TaxiEntity taxiEntity) {
        taxisRepository.save(taxiEntity);
        TaxiDto taxiDtoSaved = new TaxiDto(taxiEntity.getId(),taxiEntity.getPlate());
        return taxiDtoSaved;
    }


    @Transactional(readOnly = true)
    @Override
    public TaxiDto findById(Integer id) {
        TaxiEntity taxiDB = taxisRepository.findById(id).orElse(null);
        return new TaxiDto(taxiDB.getId(), taxiDB.getPlate());
    }

    @Transactional
    @Override
    public TaxiDto delete(Integer id) {
        TaxiEntity taxiDB = taxisRepository.findById(id).orElse(null);
        TaxiDto taxiDtoToDelete = findById(id);
        taxisRepository.delete(taxiDB);
        return taxiDtoToDelete;

//        Map<String, Object> response = new HashMap<>();
//
//        if (taxiDB != null){
//            taxisRepository.delete(taxiDB);
//            return new ResponseEntity<>(taxiDtoToDelete, HttpStatus.OK);
//        } else {
//            response.put("mensaje", "ID invalido");
//            response.put("taxi", null);
//            response.put("id", id);
//            return new ResponseEntity<>(taxiDtoToDelete, HttpStatus.NOT_FOUND);
//        }
    }

    @Transactional
    @Override
    public Iterable<TaxiEntity> findAll() {
        return taxisRepository.findAll();
    }

    @Transactional
    @Override
    public TaxiDto update(TaxiEntity taxiEntity) {
        TaxiDto taxiToUpdate = findById(taxiEntity.getId());
        if ((taxiEntity.getId() == null) | (!Objects.equals(taxiEntity.getId(), taxiToUpdate.getId()))){
            return null;
        } else {
            taxisRepository.save(taxiEntity);
            TaxiDto taxiDtoSaved = new TaxiDto(taxiEntity.getId(),taxiEntity.getPlate());
            return taxiDtoSaved;
        }
    }
}
