package org.oobootcamp;

import org.oobootcamp.status.ParkStatus;

import java.util.ArrayList;
import java.util.List;

public class GraduateParkingBoy extends ParkingBoy{
    public GraduateParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkResult park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            ParkResult parkResult = parkingLot.park(car);
            if (parkResult.isSuccess()) {
                return parkResult;
            }
        }

        return new ParkResult(ParkStatus.FAILURE);
    }

}
