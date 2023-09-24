package com.driver.services.impl;

import com.driver.model.*;
import com.driver.repository.PaymentRepository;
import com.driver.repository.ReservationRepository;
import com.driver.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    ReservationRepository reservationRepository2;
    @Autowired
    PaymentRepository paymentRepository2;

    @Override
    public Payment pay(Integer reservationId, int amountSent, String mode) throws Exception {
        Optional<Reservation>reservation=reservationRepository2.findById(reservationId);
        if(!reservation.isPresent()){
            throw new Exception("reservationId not found");
        }else{

            Reservation reservation1=reservation.get();

            int bill=reservation1.getNumberOfHour()*reservation1.getSpot().getPricePerHour();
            if(amountSent<bill){
                throw new Exception("Insufficient Amount");
            }else{
                if(mode.equals("CARD") || mode.equals("CASH") || mode.equals("UPI")){
                    Payment payment=new Payment();
                    Spot spot=reservation1.getSpot();
                    spot.setOccupied(false);
                    reservation1.setPayment(payment);
                    payment.setReservation(reservation1);
                    if(mode.equals("CARD")){
                        payment.setPaymentMode(PaymentMode.CARD);
                    }else if(mode.equals("CASH")){
                        payment.setPaymentMode(PaymentMode.CASH);
                    }else {
                        payment.setPaymentMode(PaymentMode.UPI);
                    }
                    payment.setPaymentCompleted(true);


                    Payment payment1=paymentRepository2.save(payment);
                    return payment1;
                }else{
                    throw new Exception("Payment mode not detected");
                }
            }
        }

    }
}
