package com.example.dev011fleetmanagementapi.controller;

import com.example.dev011fleetmanagementapi.model.entity.TaxiEntity;
import com.example.dev011fleetmanagementapi.model.entity.TrajectoryEntity;
import com.example.dev011fleetmanagementapi.service.ITaxi;
import com.example.dev011fleetmanagementapi.service.ITrajectory;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TrajectoriesController {

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="")

    @Autowired
    private ITrajectory iTrajectoriesService;

    @Autowired
    private ITaxi iTaxiService;

    @GetMapping("trajectories/{page}/{pageSize}")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getAll(@PathVariable Integer page, @PathVariable Integer pageSize){
        Map<String,Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(iTrajectoriesService.getAllTrajectories(page, pageSize), HttpStatus.OK);
        } catch (Error er){
            response.put("message", er.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("trajectories/taxi-id/{idTaxi}/{page}/{sizePage}")
    public ResponseEntity<?> getAllByTaxi(@PathVariable Integer idTaxi, @PathVariable Integer page, @PathVariable Integer sizePage) {
        Map<String,Object> response = new HashMap<>();
        try{
            TaxiEntity taxi = iTaxiService.findTaxiById(idTaxi);

            Iterable<TrajectoryEntity> trajectory = iTrajectoriesService.getTrajectoriesByTaxi(taxi, page,sizePage);
            return new ResponseEntity<>(trajectory, HttpStatus.OK);
        }catch (SQLException ex){
            response.put("mensaje", ex.getMessage());
            response.put("trajectory", null);
            response.put("id", idTaxi);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Error er){
            response.put("mensaje", er.getMessage());
            response.put("id", idTaxi);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("trajectory/last/taxi-id/{idTaxi}")
    public ResponseEntity<?> getLastByTaxi(@PathVariable Integer idTaxi){
        Map<String,Object> response = new HashMap<>();
        try{
            TaxiEntity taxi = iTaxiService.findTaxiById(idTaxi);
            Iterable<TrajectoryEntity> trajectory = iTrajectoriesService.getTrajectoriesByTaxi(taxi, 0,1);
            return new ResponseEntity<>(trajectory, HttpStatus.OK);
        }catch (SQLException ex){
            response.put("mensaje", ex.getMessage());
            response.put("trajectory", null);
            response.put("id", idTaxi);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Error er){
            response.put("mensaje", er.getMessage());
            response.put("id", idTaxi);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("trajectory/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Map<String,Object> response = new HashMap<>();
        try{
            TrajectoryEntity trajectory = iTrajectoriesService.getOneTrajectoryById(id);
            return new ResponseEntity<>(trajectory, HttpStatus.OK);
        }catch (SQLException ex){
            response.put("mensaje", ex.getMessage());
            response.put("trajectory", null);
            response.put("id", id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Error er){
            response.put("mensaje", er.getMessage());
            response.put("id", id);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("trajectory")
    public ResponseEntity<?> create(@RequestBody TrajectoryEntity trajectory) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(iTrajectoriesService.saveOneTrajectory(trajectory),HttpStatus.CREATED);
        } catch (SQLException | DataException ex){
            response.put("mensaje", ex.getMessage());
            response.put("trajectory", trajectory);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        } catch (Exception er){
            response.put("mensaje", er.getMessage());
            response.put("trajectory", trajectory);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("trajectory/{id}")
    public ResponseEntity<?> update(@RequestBody TrajectoryEntity trajectory, @PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(iTrajectoriesService.updateOneTrajectory(trajectory,id),HttpStatus.CREATED);
        } catch (SQLException | DataException | DataAccessException ex){
            response.put("mensaje", ex.getMessage());
            response.put("trajectory", trajectory);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        } catch (Exception er){
            response.put("mensaje", er.getMessage());
            response.put("trajectory", trajectory);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("trajectory/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(iTrajectoriesService.deleteOneTrajectoryById(id), HttpStatus.OK) ;
        } catch (SQLException ex){
            response.put("mensaje", ex.getMessage());
            response.put("trajectory", null);
            response.put("id", id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Error er){
            response.put("mensaje", er.getMessage());
            response.put("id", id);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
