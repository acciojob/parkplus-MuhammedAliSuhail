package com.driver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private boolean paymentCompleted;
    private PaymentMode paymentMode;
    @OneToOne
    @JoinColumn
    @JsonIgnore
    private Reservation reservation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isPaymentCompleted() {
        return paymentCompleted;
    }

    public void setPaymentCompleted(boolean paymentCompleted) {
        this.paymentCompleted = paymentCompleted;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Payment(boolean paymentCompleted, PaymentMode paymentMode, Reservation reservation) {
        this.paymentCompleted = paymentCompleted;
        this.paymentMode = paymentMode;
        this.reservation = reservation;
    }

    public Payment() {
    }
}
