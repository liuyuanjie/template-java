package org.oobootcamp;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) throws ParkingLotIsFullParkingFailException {
        ParkingLot parkingLot = firstParkingLotHasMostFreeSpace();
        if (parkingLot == null) {
            throw new ParkingLotIsFullParkingFailException();
        }

        return parkingLot.park(car);
    }

    private ParkingLot firstParkingLotHasMostFreeSpace() {
        ParkingLot parkingLot = parkingLots.get(0);
        for (ParkingLot item : parkingLots) {
            if (parkingLot.freeSpaceAmount() < item.freeSpaceAmount()) {
                parkingLot = item;
            }
        }

        return parkingLot;
    }
}
