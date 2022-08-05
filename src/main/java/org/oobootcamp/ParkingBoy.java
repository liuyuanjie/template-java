package org.oobootcamp;

import org.oobootcamp.status.ParkStatus;

import java.util.List;

public abstract class ParkingBoy {
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public abstract ParkResult park(Car car) ;


    public PickResult pick(Ticket ticket) {
        PickResult pickResult = null;
        for (ParkingLot parkingLot : parkingLots) {
            PickResult itemResult = parkingLot.pick(ticket);
            if (itemResult.isParkingLotTicket()) {
                pickResult = itemResult;
                break;
            }
            pickResult = itemResult;
        }

        return pickResult;
    }
}
