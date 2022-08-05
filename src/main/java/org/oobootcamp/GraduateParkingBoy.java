package org.oobootcamp;

import org.oobootcamp.Exception.ParkingLotIsFullParkingFailException;

import java.util.List;

public class GraduateParkingBoy extends ParkingBoy {
    public GraduateParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    protected ParkingLot findFirstAvailableParkingLot(){
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasFreeParkingSpace()) {
                return parkingLot;
            }
        }

        return null;
    }
}
