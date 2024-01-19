package com.example.dev011fleetmanagementapi.service.impl;

import com.example.dev011fleetmanagementapi.model.dao.TrajectoriesRepository;
import com.example.dev011fleetmanagementapi.model.entity.TaxiEntity;
import com.example.dev011fleetmanagementapi.model.entity.TrajectoryEntity;
import com.example.dev011fleetmanagementapi.service.ITaxi;
import com.example.dev011fleetmanagementapi.service.ITrajectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class TrajectoryImpl implements ITrajectory {

    @Autowired
    private TrajectoriesRepository trajectoriesRepository;

    @Autowired
    private ITaxi taxiService;

    @Transactional(readOnly = true)
    @Override
    public Iterable<TrajectoryEntity> getAllTrajectories(Integer page, Integer pageSize) {
        return trajectoriesRepository.findAll(PageRequest.of(page,pageSize).withSort(Sort.by(Sort.Direction.ASC, "date")));
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<TrajectoryEntity> getTrajectoriesByTaxi(TaxiEntity taxi, Integer page, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "date");
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        return trajectoriesRepository.findByTaxi(taxi, pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public TrajectoryEntity getOneTrajectoryById(Integer id) throws SQLException {
        TrajectoryEntity trajectoryDB = trajectoriesRepository.findById(id).orElse(null);
        if (Objects.isNull(trajectoryDB)){
            throw new SQLException("No existe una trayectoria con ese ID");
        } else {
            return trajectoryDB;
        }
    }

    @Transactional
    @Override
    public TrajectoryEntity saveOneTrajectory(TrajectoryEntity trajectoryEntity) throws Exception {
        if (Objects.isNull(trajectoryEntity)) {
            throw new SQLException("No se puede guardar una trayectoria vacía");
        } else if (Objects.isNull(trajectoryEntity.getTaxi())){
            throw new SQLException("No se puede guardar una trayectoria sin un taxi asociado");
        } else if (Objects.isNull(trajectoryEntity.getTaxi().getPlate()) ||
                trajectoryEntity.getTaxi().getPlate() =="" ||
                trajectoryEntity.getTaxi().getPlate().length() != 9){
            throw new SQLException("'plate' ingresada inválido");
        } else if (Objects.isNull(trajectoryEntity.getLatitude()) ||
                trajectoryEntity.getLatitude()< -90 ||
                trajectoryEntity.getLatitude()>90) {
            throw new SQLException("'latitude' ingresada inválida");
        } else if (Objects.isNull(trajectoryEntity.getLongitude()) ||
                trajectoryEntity.getLongitude()< -180 ||
                trajectoryEntity.getLongitude()>180) {
            throw new SQLException("'longitude' ingresada inválida");
        } else if (Objects.isNull(trajectoryEntity.getDate()) ||
                trajectoryEntity.getDate().toLocalDateTime().isAfter(LocalDateTime.now())) {
            throw new DateTimeException("'date' ingresada inválida");
        } else {
            return trajectoriesRepository.save(trajectoryEntity);
        }
    }

    @Transactional
    @Override
    public TrajectoryEntity updateOneTrajectory(TrajectoryEntity trajectoryEntity, Integer id) throws SQLException {
        try {
            TrajectoryEntity trajectoryToUpdate = getOneTrajectoryById(id);
            if (Objects.isNull(trajectoryEntity)) {
                throw new SQLException("No se puede guardar una trayectoria vacía");
            } else if (!Objects.equals( trajectoryToUpdate.getId(), trajectoryEntity.getId())){
                throw new DataAccessException("No puede modificar el ID de la trayectoria"){};
            } else if (Objects.isNull(trajectoryEntity.getTaxi())){
                throw new SQLException("No se puede guardar una trayectoria sin un taxi asociado");
            } else if (Objects.isNull(trajectoryEntity.getTaxi().getPlate()) ||
                    trajectoryEntity.getTaxi().getPlate() =="" ||
                    trajectoryEntity.getTaxi().getPlate().length() != 9){
                throw new SQLException("'plate' ingresada inválido");
            } else if (Objects.isNull(trajectoryEntity.getLatitude()) ||
                    trajectoryEntity.getLatitude()< -90 ||
                    trajectoryEntity.getLatitude()>90) {
                throw new SQLException("'latitude' ingresada inválida");
            } else if (Objects.isNull(trajectoryEntity.getLongitude()) ||
                    trajectoryEntity.getLongitude()< -180 ||
                    trajectoryEntity.getLongitude()>180) {
                throw new SQLException("'longitude' ingresada inválida");
            } else if (Objects.isNull(trajectoryEntity.getDate()) ||
                    trajectoryEntity.getDate().toLocalDateTime().isAfter(LocalDateTime.now())) {
                throw new DateTimeException("'date' ingresada inválida");
            } else {
                return trajectoriesRepository.save(trajectoryEntity);
            }
        } catch (SQLException ex){
            throw new SQLException("No existe una trayectoria con ese ID");
        }
    }

    @Transactional
    @Override
    public TrajectoryEntity deleteOneTrajectoryById(Integer id) throws SQLException {
        TrajectoryEntity trajectoryDB = trajectoriesRepository.findById(id).orElse(null);
        if(Objects.nonNull(trajectoryDB)){
            TrajectoryEntity trajectoryToDelete = getOneTrajectoryById(id);
            trajectoriesRepository.delete(trajectoryDB);
            return trajectoryToDelete;
        } else {
            throw new SQLException("No existe una trayectoria con ese ID");
        }
    }

    @Transactional
    @Override
    public List<TrajectoryEntity> deleteTrajectoriesByTaxiId(Integer id) throws SQLException {

        List<TrajectoryEntity> trajectoriesDB = trajectoriesRepository.findByTaxi(taxiService.findTaxiById(id));
        if (Objects.nonNull(trajectoriesDB)){
            List<TrajectoryEntity> trajectoriesByTaxiDB = trajectoriesRepository.findByTaxi(taxiService.findTaxiById(id));
            trajectoriesRepository.deleteAll(trajectoriesByTaxiDB);
            return trajectoriesByTaxiDB;
        } else {
            throw new SQLException("No existen trayectorias asociadas a un taxi con ese ID");
        }

    }
}
