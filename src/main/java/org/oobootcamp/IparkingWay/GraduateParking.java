package org.oobootcamp.IparkingWay;

import org.oobootcamp.Car;
import org.oobootcamp.ParkResult;
import org.oobootcamp.ParkingLot;
import org.oobootcamp.status.ParkStatus;

import java.util.List;

public class GraduateParking implements IParking {
    @Override
    public ParkResult park(Car car, List<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            ParkResult parkResult = parkingLot.park(car);
            if (parkResult.isSuccess()) {
                return parkResult;
            }
        }

        return new ParkResult(ParkStatus.FAILURE);
    }
}
