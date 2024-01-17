package com.example.dev011fleetmanagementapi.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
public class TaxiDto implements Serializable {

    final Integer id;

    final String plate;

    public TaxiDto(Integer id, String plate) {
        this.id = id;
        this.plate = plate;
    }

}
