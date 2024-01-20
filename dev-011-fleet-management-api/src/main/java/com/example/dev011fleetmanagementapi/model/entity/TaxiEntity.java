package com.example.dev011fleetmanagementapi.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "taxis")
public class TaxiEntity implements Serializable {

    @Id
    @Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "plate")
    private String plate;

}
