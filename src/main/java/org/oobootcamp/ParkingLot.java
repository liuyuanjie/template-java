package org.oobootcamp;

public class ParkingLot {
    public ParkingLot(int capability) {

    }

    ParkResult Park(Car car)
    {
        var ticket = new Ticket();
        return new ParkResult(ticket);
    }
}
