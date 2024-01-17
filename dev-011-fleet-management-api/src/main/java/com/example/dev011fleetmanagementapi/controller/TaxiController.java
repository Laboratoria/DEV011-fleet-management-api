package com.example.dev011fleetmanagementapi.controller;

import com.example.dev011fleetmanagementapi.model.dto.TaxiDto;
import com.example.dev011fleetmanagementapi.model.entity.TaxiEntity;
import com.example.dev011fleetmanagementapi.service.ITaxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TaxiController {

    @Autowired
    private ITaxi iTaxiService;

    @PostMapping("taxi")
    @ResponseStatus(HttpStatus.CREATED)
    public TaxiDto create(@RequestBody TaxiEntity taxiEntity){
        return iTaxiService.save(taxiEntity);
    }

    @PutMapping("taxi/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody TaxiEntity taxiEntity, @PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try{
            return new ResponseEntity<>(iTaxiService.save(taxiEntity), HttpStatus.OK);
        } catch (Error | Exception ex){
            response.put("mensaje", ex.getMessage());
            response.put("taxi", null);
            response.put("id", id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("taxi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(iTaxiService.delete(id), HttpStatus.OK);
        } catch (Error | Exception ex){
            response.put("mensaje", ex.getMessage());
            response.put("taxi", null);
            response.put("id", id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("taxi/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaxiDto getById(@PathVariable Integer id){
        return iTaxiService.findById(id);
    }

    @GetMapping("taxis")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<TaxiEntity> getAll(){
        return iTaxiService.findAll();
    }
}
