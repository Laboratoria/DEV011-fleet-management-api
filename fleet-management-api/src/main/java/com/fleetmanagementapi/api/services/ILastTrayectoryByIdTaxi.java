package com.fleetmanagementapi.api.services;



import com.fleetmanagementapi.api.model.entities.Trajectory;

import java.util.List;

public interface ILastTrayectoryByIdTaxi  {

  List<Trajectory>findTrajectoryByTaxiId(Integer taxiId);
}
