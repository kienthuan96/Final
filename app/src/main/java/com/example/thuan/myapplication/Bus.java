package com.example.thuan.myapplication;

/**
 * Created by Thuan on 3/22/2018.
 */

public class Bus {

    private Integer maXe,bus_id;
    private String tenXe;

    public Bus() {
    }

    public Bus(Integer maXe, String tenXe) {
        this.maXe = maXe;
        this.tenXe = tenXe;
    }

    public Bus(Integer maXe, Integer bus_id, String tenXe) {
        this.maXe = maXe;
        this.bus_id = bus_id;
        this.tenXe = tenXe;
    }

    public Integer getMaXe() {
        return maXe;
    }

    public void setMaXe(Integer maXe) {
        this.maXe = maXe;
    }

    public Integer getBus_id() {
        return bus_id;
    }

    public void setBus_id(Integer bus_id) {
        this.bus_id = bus_id;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }
}
