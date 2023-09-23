package com.driver.services.impl;

import com.driver.model.*;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.ReservationRepository;
import com.driver.repository.SpotRepository;
import com.driver.repository.UserRepository;
import com.driver.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    UserRepository userRepository3;
    @Autowired
    SpotRepository spotRepository3;
    @Autowired
    ReservationRepository reservationRepository3;
    @Autowired
    ParkingLotRepository parkingLotRepository3;
    @Override
    public Reservation reserveSpot(Integer userId, Integer parkingLotId, Integer timeInHours, Integer numberOfWheels) throws Exception {
        Optional<User> user=userRepository3.findById(userId);
        Optional<ParkingLot> parkingLot=parkingLotRepository3.findById(parkingLotId);
        if(!user.isPresent() || !parkingLot.isPresent()){
            throw new Exception("Cannot make reservation");
        }else{
            Reservation reservation=new Reservation();
            ParkingLot parkingLot1=parkingLot.get();
            List<Spot> spotlist=parkingLot1.getSpotList();
            Collections.sort(spotlist,(a,b)->a.getPricePerHour().compareTo(b.getPricePerHour()));
            User user1=user.get();
            reservation.setUser(user1);
            reservation.setNumberOfHours(timeInHours);
            for(Spot spot:spotlist){
                if(numberOfWheels==4) {
                    if (spot.getOccupied() && spot.getSpotType()==SpotType.FOUR_WHEELER) {
                        spot.setOccupied(true);
                        reservation.setSpot(spot);
                        break;
                    }
                } else if (numberOfWheels==2) {
                    if (spot.getOccupied() && spot.getSpotType()==SpotType.TWO_WHEELER) {
                        spot.setOccupied(true);
                        reservation.setSpot(spot);
                        break;
                    }
                }else{
                    if (spot.getOccupied() && spot.getSpotType()==SpotType.OTHERS) {
                        spot.setOccupied(true);
                        reservation.setSpot(spot);
                        break;
                    }
                }
            }
            if(reservation.getSpot()==null)throw new Exception("Cannot make reservation");


           Reservation reservation1= reservationRepository3.save(reservation);
           return reservation1;
        }

    }
}
