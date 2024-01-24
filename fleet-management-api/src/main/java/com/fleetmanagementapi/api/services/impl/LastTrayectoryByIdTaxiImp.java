package com.fleetmanagementapi.api.services.impl;

import com.fleetmanagementapi.api.model.entities.Trajectory;
import com.fleetmanagementapi.api.model.repository.TrajectoryRepository;
import com.fleetmanagementapi.api.services.ILastTrayectoryByIdTaxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LastTrayectoryByIdTaxiImp implements ILastTrayectoryByIdTaxi {

    @Autowired
    TrajectoryRepository trajectoryRepository;

    @Override
    public List<Trajectory> findTrajectoryByTaxiId(Integer taxiId){
         List<Trajectory> trajectories =  trajectoryRepository.findLastTrajectory(taxiId);
        /* List<LastTrayectoryDTO> trayectoryDTOS = new ArrayList<>();
        for (int i = 0; i < trajectories.size() ; i++) {
           Trajectory trajectory = trajectories.get(i);
          LastTrayectoryDTO trayectoryDTO = new LastTrayectoryDTO();
          trayectoryDTO.setDate(trajectory.getDate());
          trayectoryDTO.setTaxi_id(trajectory.getTaxi().getId());
          trayectoryDTO.setPlate(trajectory.getTaxi().getPlate());
          trayectoryDTO.setLatitude(trajectory.getLatitude());
          trayectoryDTO.setLongitude(trajectory.getLongitude());
            trayectoryDTOS.add(trayectoryDTO);
        };*/
                 return trajectories;
    }

}
