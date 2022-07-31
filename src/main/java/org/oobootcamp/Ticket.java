package org.oobootcamp;

import java.util.UUID;

public class Ticket {
    UUID ticketNo;
    private ParkingLot parkingLot;

    public Ticket(ParkingLot parkingLot) {
        ticketNo = UUID.randomUUID();

        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return this.parkingLot;
    }
}
