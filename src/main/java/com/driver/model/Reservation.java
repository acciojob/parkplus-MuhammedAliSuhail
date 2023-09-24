package com.driver.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table
@Entity
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer numberOfHour;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Spot spot;

    @OneToOne
    @JsonIgnore
    private Payment payment;

    public Integer getNumberOfHours() {
        return numberOfHour;
    }

    public void setNumberOfHours(Integer numberOfHour) {
        this.numberOfHour = numberOfHour;
    }

    public Integer getNumberOfHour() {
        return numberOfHour;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Payment getPayment() {
        return payment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Reservation(Integer id, Integer numberOfHour, User user, Spot spot, Payment payment) {
        this.id = id;
        this.numberOfHour = numberOfHour;
        this.user = user;
        this.spot = spot;
        this.payment = payment;
    }

    public Reservation(Integer numberOfHour, User user, Spot spot, Payment payment) {
        this.numberOfHour = numberOfHour;
        this.user = user;
        this.spot = spot;
        this.payment = payment;
    }

    public Reservation() {
    }
}
