package com.example.dev011fleetmanagementapi.service.impl;

import com.example.dev011fleetmanagementapi.model.dao.TrajectoriesRepository;
import com.example.dev011fleetmanagementapi.model.entity.Trajectories;
import com.example.dev011fleetmanagementapi.service.ITrajectories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrajertoriesImpl implements ITrajectories {

    @Autowired
    private TrajectoriesRepository trajectoriesRepository;

    @Transactional
    @Override
    public Trajectories save(Trajectories trajectories) {
        return trajectoriesRepository.save(trajectories);
    }

    @Transactional(readOnly = true)
    @Override
    public Trajectories findById(Integer id) {
        return trajectoriesRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Trajectories trajectories) {
        trajectoriesRepository.delete(trajectories);
    }

    @Transactional
    @Override
    public Trajectories update(Trajectories trajectories) {
        return trajectoriesRepository.save(trajectories);
    }
}
