package org.oobootcamp;

import org.oobootcamp.status.ParkStatus;

import java.util.ArrayList;
import java.util.List;

public class GraduateParkingBoy extends ParkingBoy{
    public GraduateParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) throws ParkFailException {
        for (ParkingLot parkingLot : parkingLots) {
            if(!parkingLot.HasFreeParking())
            {
                continue;
            }

            return parkingLot.park(car);

        }

        throw new ParkFailException("Park failed. Parking lot is full.");
    }

}
