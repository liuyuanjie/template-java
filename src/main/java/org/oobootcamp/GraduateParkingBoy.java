package org.oobootcamp;

import org.oobootcamp.status.ParkStatus;

import java.util.ArrayList;
import java.util.List;

public class GraduateParkingBoy {
    protected List<ParkingLot> parkingLots;

    public GraduateParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkResult park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            ParkResult parkResult = parkingLot.park(car);
            if (parkResult.isSuccess()) {
                return parkResult;
            }
        }

        return new ParkResult(ParkStatus.FAILURE);
    }

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
