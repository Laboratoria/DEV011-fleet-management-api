package com.example.dev011fleetmanagementapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trajectories")
public class TrajectoryEntity implements Serializable {
    @Id

    @Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "taxi_id", referencedColumnName = "id")
    //@JsonIgnore
    private TaxiEntity taxi;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;
}
