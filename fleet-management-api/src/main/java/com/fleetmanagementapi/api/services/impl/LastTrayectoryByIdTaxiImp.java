package com.fleetmanagementapi.api.services.impl;

import com.fleetmanagementapi.api.model.DTO.LastTrayectoryDTO;
import com.fleetmanagementapi.api.model.repository.LastTrayectoryByTaxiIdRepository;
import com.fleetmanagementapi.api.services.ILastTrayectoryByIdTaxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LastTrayectoryByIdTaxiImp implements ILastTrayectoryByIdTaxi {

    @Autowired
    LastTrayectoryByTaxiIdRepository lastTrayectoryByTaxiIdRepository;

    @Override
    public Page<LastTrayectoryDTO> findTrayectoryByTaxiId(Pageable pageable, Integer taxiId){
        return lastTrayectoryByTaxiIdRepository.findTrayectoryByTaxiId(pageable, taxiId);
    }
}
