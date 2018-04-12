package com.example.thuan.myapplication;

public class Bus_Station {
    private Integer bus_id,station_id;

    public Bus_Station(Integer bus_id, Integer station_id) {
        this.bus_id = bus_id;
        this.station_id = station_id;
    }

    public Bus_Station() {
    }

    public Integer getBus_id() {
        return bus_id;
    }

    public void setBus_id(Integer bus_id) {
        this.bus_id = bus_id;
    }

    public Integer getStation_id() {
        return station_id;
    }

    public void setStation_id(Integer station_id) {
        this.station_id = station_id;
    }
}
