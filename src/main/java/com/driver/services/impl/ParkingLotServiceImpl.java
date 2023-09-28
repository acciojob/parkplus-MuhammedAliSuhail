package com.driver.services.impl;

import com.driver.model.ParkingLot;
import com.driver.model.Spot;
import com.driver.model.SpotType;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.SpotRepository;
import com.driver.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    ParkingLotRepository parkingLotRepository1;
    @Autowired
    SpotRepository spotRepository1;
    @Override
    public ParkingLot addParkingLot(String name, String address) {
        ParkingLot parkingLot=new ParkingLot(name,address);
        ParkingLot parkingLot1=parkingLotRepository1.save(parkingLot);
        return parkingLot1;
    }

    @Override
    public Spot addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour) throws Exception {

         Spot spot=new Spot();

         Optional<ParkingLot>parkingLot=parkingLotRepository1.findById(parkingLotId);
         if(!parkingLot.isPresent()){
             throw new Exception("parking lot id not found");
         }else {
             ParkingLot parkingLot1=parkingLot.get();
             spot.setParkingLot(parkingLot1);
             spot.setOccupied(false);
             spot.setPricePerHour(pricePerHour);
             if (numberOfWheels == 4) {
                 spot.setSpotType(SpotType.FOUR_WHEELER);
             } else if (numberOfWheels == 2) {
                 spot.setSpotType(SpotType.TWO_WHEELER);
             } else {
                 spot.setSpotType(SpotType.OTHERS);
             }
             Spot spot1 = spotRepository1.save(spot);


             return spot1;
         }
    }

    @Override
    public void deleteSpot(int spotId) {
        Optional<Spot> spot=spotRepository1.findById(spotId);
        if(spot.isPresent()) {
            spotRepository1.deleteById(spotId);
        }
    }

    @Override
    public Spot updateSpot(int parkingLotId, int spotId, int pricePerHour) throws Exception {

        Optional<Spot> spot=spotRepository1.findById(spotId);
        if(!spot.isPresent()){
            throw new Exception("spot id is not presant");
        }else{
            Spot spot1=spot.get();
            Optional<ParkingLot> parkingLot=parkingLotRepository1.findById(parkingLotId);
            if(!parkingLot.isPresent()){
                throw new Exception("parking lot id not presant");
            }else{
                ParkingLot parkingLot1=parkingLot.get();
                spot1.setParkingLot(parkingLot1);
                spot1.setPricePerHour(pricePerHour);
                Spot save=spotRepository1.save(spot1);
                return save;
            }

        }

    }

    @Override
    public void deleteParkingLot(int parkingLotId) {
        Optional<ParkingLot> parkingLot=parkingLotRepository1.findById(parkingLotId);
        if(parkingLot.isPresent()) {
            parkingLotRepository1.deleteById(parkingLotId);
        }
    }
}
