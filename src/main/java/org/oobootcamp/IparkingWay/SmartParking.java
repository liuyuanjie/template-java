package org.oobootcamp.IparkingWay;

import org.oobootcamp.Car;
import org.oobootcamp.ParkResult;
import org.oobootcamp.ParkingLot;
import org.oobootcamp.status.ParkStatus;

import java.util.List;

public class SmartParking implements IParking {
    @Override
    public ParkResult park(Car car, List<ParkingLot> parkingLots) {
        ParkingLot parkingLot = firstHasMostFreeSpaceParkingLot(parkingLots);
        ParkResult parkResult = parkingLot.park(car);

        return parkResult.isSuccess() ? parkResult : new ParkResult(ParkStatus.FAILURE);
    }

    private ParkingLot firstHasMostFreeSpaceParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot parkingLot = parkingLots.get(0);
        for (ParkingLot item : parkingLots) {
            if (parkingLot.freeSpace() < item.freeSpace()) {
                parkingLot = item;
            }
        }

        return parkingLot;
    }
}
