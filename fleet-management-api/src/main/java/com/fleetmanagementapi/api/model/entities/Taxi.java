package com.fleetmanagementapi.api.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="taxis")
public class Taxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String plate;

    public Integer getId() {
        return id;
    }

    @OneToMany(mappedBy = "taxiId")
    List<Trajectorie> trajectories;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
