package com.example.thuan.myapplication;

public class Station {
    private Integer station_id;
    private String name;

    public Station() {
    }

    public Station(String name) {
        this.name = name;
    }

    public Station(Integer station_id, String name) {
        this.station_id = station_id;
        this.name = name;
    }

    public Integer getStation_id() {
        return station_id;
    }

    public void setStation_id(Integer station_id) {
        this.station_id = station_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
