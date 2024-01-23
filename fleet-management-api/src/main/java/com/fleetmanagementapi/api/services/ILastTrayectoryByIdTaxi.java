package com.fleetmanagementapi.api.services;

import com.fleetmanagementapi.api.model.DTO.LastTrayectoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILastTrayectoryByIdTaxi  {

Page<LastTrayectoryDTO> findTrayectoryByTaxiId(Pageable pageable, Integer taxiId);
}
