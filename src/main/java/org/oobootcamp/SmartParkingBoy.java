package org.oobootcamp;

import org.oobootcamp.status.ParkStatus;

import java.util.List;

public class SmartParkingBoy extends GraduateParkingBoy {


    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkResult park(Car car) {
        ParkingLot parkingLot = FindFirstHasMostFreeSpaceParkingLot();
        ParkResult parkResult = parkingLot.park(car);
        if (parkResult.isSuccess()) {
            return parkResult;
        }

        return new ParkResult(ParkStatus.FAILURE);
    }

    private ParkingLot FindFirstHasMostFreeSpaceParkingLot() {
        if (parkingLots == null || parkingLots.size() < 1) {
            return null;
        }

        ParkingLot parkingLot = parkingLots.get(0);
        for (ParkingLot item : parkingLots) {
            if (parkingLot.freeSpace() < item.freeSpace()) {
                parkingLot = item;
            }
        }

        return parkingLot;
    }
}
