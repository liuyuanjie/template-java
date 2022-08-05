package org.oobootcamp;

import org.oobootcamp.Exception.InvalidTicketPickingFailException;
import org.oobootcamp.Exception.ParkingLotIsFullParkingFailException;

import java.util.HashMap;

public class ParkingLot {
    private final int capacity;
    private final HashMap<Ticket, Car> parkedCars = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    Ticket park(Car car) throws ParkingLotIsFullParkingFailException {
        if (!hasFreeParkingSpace()) {
            throw new ParkingLotIsFullParkingFailException();
        }

        var ticket = new Ticket();

        parkedCars.put(ticket, car);

        return ticket;
    }

    public Car pick(Ticket ticket) throws InvalidTicketPickingFailException {
        if (!IsValidTicket(ticket)) {
            throw new InvalidTicketPickingFailException();
        }

        Car car = parkedCars.get(ticket);
        parkedCars.remove(ticket);

        return car;
    }

    public boolean IsValidTicket(Ticket ticket) {
        return parkedCars.containsKey(ticket);
    }

    public boolean hasFreeParkingSpace() {
        return capacity > parkedCars.size();
    }

    public int parkingSpaceIsFreeAmount() {
        return capacity - parkedCars.size();
    }

}