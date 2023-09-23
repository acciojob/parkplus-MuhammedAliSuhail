package com.driver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


@Table
@Entity
public class ParkingLot {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "parkingLot",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Spot> spotList=new LinkedList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Spot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<Spot> spotList) {
        this.spotList = spotList;
    }

    public ParkingLot(Integer id, String name, String address, List<Spot> spotList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.spotList = spotList;
    }

    public ParkingLot(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public ParkingLot() {
    }
}
