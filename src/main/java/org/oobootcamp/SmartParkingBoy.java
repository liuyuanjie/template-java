package org.oobootcamp;

import org.oobootcamp.Exception.ParkingLotIsFullParkingFailException;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    protected ParkingLot firstAvailableParkingLot() {
        ParkingLot parkingLot = parkingLots.get(0);
        for (ParkingLot item : parkingLots) {
            if (parkingLot.parkingSpaceIsFreeAmount() < item.parkingSpaceIsFreeAmount()) {
                parkingLot = item;
            }
        }

        return parkingLot;
    }
}
