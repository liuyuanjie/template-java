package org.oobootcamp;

import java.util.ArrayList;

public class GraduateParkingBoy {
    private ArrayList<ParkingLot> parkingLots;

    public GraduateParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkResult park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            ParkResult parkResult = parkingLot.park(car);
            if (parkResult.hasTicket()) {
                return parkResult;
            }
        }

        return new ParkResult(null);
    }

    public PickResult pick(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            PickResult pickResult = parkingLot.pick(ticket);
            if (pickResult.isParkingLotTicket()) {
                return pickResult;
            }
        }

        return new PickResult(PickCarStatus.InvalidTicket);
    }
}
