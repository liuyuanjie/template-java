package org.oobootcamp;

import org.oobootcamp.Exception.InvalidTicketPickingFailException;
import org.oobootcamp.Exception.ParkingLotIsFullParkingFailException;
import org.oobootcamp.Exception.PickingFailException;
import org.oobootcamp.Exception.TicketHasPickedPickingFailException;

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
        ticket.park();

        parkedCars.put(ticket, car);

        return ticket;
    }

    public Car pick(Ticket ticket) throws PickingFailException {
        if (!IsValidTicket(ticket)) {
            throw new InvalidTicketPickingFailException();
        }

        if (ticket.hasPicked()) {
            throw new TicketHasPickedPickingFailException();
        }

        Car car = parkedCars.get(ticket);
        ticket.pick();

        return car;
    }

    public boolean IsValidTicket(Ticket ticket) {
        return parkedCars.containsKey(ticket);
    }

    public boolean hasFreeParkingSpace() {
        return capacity > parkingSpaceIsInPackedAmount();
    }

    public int parkingSpaceIsFreeAmount() {
        return capacity - parkingSpaceIsInPackedAmount();
    }

    private int parkingSpaceIsInPackedAmount() {
        return (int) parkedCars.keySet().stream().filter(Ticket::hasNotPicked).count();
    }
}