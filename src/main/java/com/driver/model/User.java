package com.driver.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Table
@Entity
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String PhoneNumber;

    private String Password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Reservation> reservationList=new LinkedList<>();

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

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public User(Integer id, String name, String phoneNumber, String password, List<Reservation> reservationList) {
        this.id = id;
        this.name = name;
        PhoneNumber = phoneNumber;
        Password = password;
        this.reservationList = reservationList;
    }

    public User(String name, String phoneNumber, String password) {
        this.name = name;
        PhoneNumber = phoneNumber;
        Password = password;
    }

    public User() {
    }
}
