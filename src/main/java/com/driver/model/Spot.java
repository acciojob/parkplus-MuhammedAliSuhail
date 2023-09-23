package com.driver.model;


import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Table
@Entity
public class Spot {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private SpotType spotType;
    private Integer pricePerHour;
    private boolean occupied;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private ParkingLot parkingLot;
    @com.fasterxml.jackson.annotation.JsonIgnore
    @OneToMany(mappedBy = "spot",cascade = CascadeType.ALL)
    private List<Reservation> reservationList=new LinkedList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public Integer getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Integer pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public Spot(Integer id, SpotType spotType, Integer pricePerHour, boolean occupied, ParkingLot parkingLot, List<Reservation> reservationList) {
        this.id = id;
        this.spotType = spotType;
        this.pricePerHour = pricePerHour;
        this.occupied = occupied;
        this.parkingLot = parkingLot;
        this.reservationList = reservationList;
    }

    public Spot(SpotType spotType, Integer pricePerHour, boolean occupied, ParkingLot parkingLot) {
        this.spotType = spotType;
        this.pricePerHour = pricePerHour;
        this.occupied = occupied;
        this.parkingLot = parkingLot;
    }

    public Spot() {
    }
}
