package org.oobootcamp;

import java.util.List;

public abstract class ParkingBoy {
    protected List<ParkingLot> parkingLots;

    protected ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public abstract Ticket park(Car car) throws ParkingLotIsFullParkingFailException;

    public Car pick(Ticket ticket) throws PickingFailException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.ContainsTicket(ticket)) {
                return parkingLot.pick(ticket);
            }
        }

        throw new PickingFailException();
    }
}
