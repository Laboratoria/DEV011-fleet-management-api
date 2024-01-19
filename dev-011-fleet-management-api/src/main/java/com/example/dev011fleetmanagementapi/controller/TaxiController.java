package com.example.dev011fleetmanagementapi.controller;

import com.example.dev011fleetmanagementapi.model.entity.TaxiEntity;
import com.example.dev011fleetmanagementapi.service.ITaxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TaxiController {

    @Autowired
    private ITaxi iTaxiService;

    @GetMapping("taxis/{page}/{pageSize}")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getAll(@PathVariable Integer page, @PathVariable Integer pageSize){
        Map<String,Object> response = new HashMap<>();

        try {
            return new ResponseEntity<>(iTaxiService.findAllTaxis(page, pageSize), HttpStatus.OK);
        } catch (Error er){
            response.put("message", er.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("taxi/{id}")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try{
            return new ResponseEntity<>(iTaxiService.findTaxiById(id), HttpStatus.OK);
        } catch (SQLException ex){
            response.put("mensaje", ex.getMessage());
            response.put("taxi", null);
            response.put("id", id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Error er){
            response.put("mensaje", er.getMessage());
            response.put("id", id);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("taxi")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody TaxiEntity taxiEntity){
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(iTaxiService.saveTaxi(taxiEntity),HttpStatus.CREATED);
        } catch (SQLException ex){
            response.put("mensaje", ex.getMessage());
            response.put("plate", taxiEntity.getPlate());
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        } catch (Exception er){
            response.put("mensaje", er.getMessage());
            response.put("plate", taxiEntity.getPlate());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("taxi/{id}")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody TaxiEntity taxiEntity, @PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try{
            return new ResponseEntity<>(iTaxiService.updateTaxi(taxiEntity, id), HttpStatus.OK);
        } catch (DataAccessException|SQLException ex){
            response.put("mensaje", ex.getMessage());
            response.put("taxi", null);
            response.put("id", id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Error er){
            response.put("mensaje", er.getMessage());
            response.put("taxi", null);
            response.put("id", id);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("taxi/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(iTaxiService.deleteTaxi(id), HttpStatus.OK);
        } catch (SQLException ex){
            response.put("mensaje", ex.getMessage());
            response.put("taxi", null);
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
