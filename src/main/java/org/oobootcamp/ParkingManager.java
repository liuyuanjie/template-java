package org.oobootcamp;

import org.oobootcamp.Exception.ParkingLotIsFullParkingFailException;

import java.util.List;

public class ParkingManager {
    private List<ParkingBoy> parkingBoys;
    private List<ParkingLot> parkingLots;

    public ParkingManager(List<ParkingBoy> parkingBoys, List<ParkingLot> parkingLots) {

        this.parkingBoys = parkingBoys;
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws ParkingLotIsFullParkingFailException {
        for (ParkingBoy parkingBoy : parkingBoys) {
            if (parkingBoy.hasFreeParkingSpace()) {
                return parkingBoy.park(car);
            }
        }

        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasFreeParkingSpace()) {
                return parkingLot.park(car);
            }
        }
        throw new ParkingLotIsFullParkingFailException();
    }
}
