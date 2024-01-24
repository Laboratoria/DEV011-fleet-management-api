package com.fleetmanagementapi.api.model.DTO;

import java.util.Date;

public class Trajectory {
    private Integer taxi_id;
    private String plate;
    private Date date;
    private Double longitude;
    private Double latitude;

    public Integer getTaxi_id() {
        return taxi_id;
    }

    public void setTaxi_id(Integer taxi_id) {
        this.taxi_id = taxi_id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
