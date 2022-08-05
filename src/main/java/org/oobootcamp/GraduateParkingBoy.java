package org.oobootcamp;

import java.util.List;

public class GraduateParkingBoy extends ParkingBoy{
    public GraduateParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) throws ParkingLotIsFullParkingFailException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasFreeParking()) {
                return parkingLot.park(car);
            }
        }

        throw new ParkingLotIsFullParkingFailException();
    }
}
