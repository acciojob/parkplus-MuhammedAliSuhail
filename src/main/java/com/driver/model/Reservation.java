package com.driver.model;


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
    private User user;

    @ManyToOne
    @JoinColumn
    private Spot spot;

    @OneToOne
    private Payment payment;

    public Integer getNumberOfHour() {
        return numberOfHour;
    }

    public void setNumberOfHour(Integer numberOfHour) {
        this.numberOfHour = numberOfHour;
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
