package org.oobootcamp;

import org.oobootcamp.Exception.ParkingLotIsFullParkingFailException;

import java.util.List;

public class GraduateParkingBoy extends ParkingBoy {
    public GraduateParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) throws ParkingLotIsFullParkingFailException {
        ParkingLot parkingLot = firstParkingLotHasFreeParkingSpace();

        return parkingLot.park(car);
    }

    private ParkingLot firstParkingLotHasFreeParkingSpace() {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasFreeParkingSpace()) {
                return parkingLot;
            }
        }

        return new ParkingLot(0);
    }
}
