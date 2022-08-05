package org.oobootcamp;

import org.oobootcamp.status.ParkStatus;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy{


    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkResult park(Car car) {
        ParkingLot parkingLot =  FindTheMostEmptyParkingLotWithOrderWhenRemadingSpaceIsTheSame();
        ParkResult parkResult = parkingLot.park(car);
        if (parkResult.isSuccess()) {
            return parkResult;
        }

        return new ParkResult(ParkStatus.FAILURE);
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
