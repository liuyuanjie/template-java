package org.oobootcamp;

import java.util.UUID;

public class Ticket {
    UUID ticketNo;
    ParkingLot parkingLot;

    public Ticket(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        ticketNo = UUID.randomUUID();
    }
}
