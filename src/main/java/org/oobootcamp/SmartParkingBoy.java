package org.oobootcamp;

import org.oobootcamp.status.ParkStatus;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy{


    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) throws ParkFailException {
        ParkingLot parkingLot =  FindTheMostEmptyParkingLotWithOrderWhenRemadingSpaceIsTheSame();
        if(parkingLot == null)
        {
            throw new ParkFailException("Park failed. Parking lot is full.");
        }

        return parkingLot.park(car);
    }

    private ParkingLot FindTheMostEmptyParkingLotWithOrderWhenRemadingSpaceIsTheSame()
    {
         if(parkingLots ==null || parkingLots.size()<1)
         {
             return null;
         }

         ParkingLot maxCapacityParkingLots = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots)
        {
            if(maxCapacityParkingLots.remaindingSpace() < parkingLot.remaindingSpace())
            {
                maxCapacityParkingLots = parkingLot;
            }
        }

        return maxCapacityParkingLots;
    }

}
