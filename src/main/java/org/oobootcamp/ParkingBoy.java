package org.oobootcamp;

import org.oobootcamp.status.ParkStatus;

import java.util.List;

public abstract class ParkingBoy {
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public abstract Ticket park(Car car) throws ParkFailException;


    public Car pick(Ticket ticket) throws PickFailException {
        Car car = null;
        for (ParkingLot parkingLot : parkingLots) {

            if(!parkingLot.ContainsTicket(ticket))
            {
                continue;
            }

            return parkingLot.pick(ticket);
        }

        throw new PickFailException("Pick failed. Invalid ticket.");
    }
}
