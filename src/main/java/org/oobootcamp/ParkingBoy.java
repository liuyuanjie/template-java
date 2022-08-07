package org.oobootcamp;

import org.oobootcamp.Exception.InvalidTicketPickingFailException;
import org.oobootcamp.Exception.ParkingLotIsFullParkingFailException;

import java.util.List;

public abstract class ParkingBoy {
    protected List<ParkingLot> parkingLots;

    protected ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws ParkingLotIsFullParkingFailException {
        ParkingLot parkingLot = findFirstAvailableParkingLot();
        if (parkingLot == null) {
            throw new ParkingLotIsFullParkingFailException();
        }
        return parkingLot.park(car);
    }

    public Car pick(Ticket ticket) throws InvalidTicketPickingFailException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.IsValidTicket(ticket)) {
                return parkingLot.pick(ticket);
            }
        }

        throw new InvalidTicketPickingFailException();
    }

    protected abstract ParkingLot findFirstAvailableParkingLot() throws ParkingLotIsFullParkingFailException;

    public boolean hasFreeParkingSpace() {
        return parkingLots.stream().filter(x -> x.hasFreeParkingSpace()).count() > 0;
    }
}
