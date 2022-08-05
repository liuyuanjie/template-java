package org.oobootcamp;

import java.util.HashMap;

public class ParkingLot {
    private final int capacity;
    private final HashMap<Ticket, Car> parkedCars = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    Ticket park(Car car) throws ParkingLotIsFullParkingFailException {
        if (!hasFreeParking()) {
            throw new ParkingLotIsFullParkingFailException();
        }

        var ticket = new Ticket();
        ticket.park();

        parkedCars.put(ticket, car);

        return ticket;
    }

    public Car pick(Ticket ticket) throws PickingFailException {
        if (!parkedCars.containsKey(ticket)) {
            throw new InvalidTicketPickingFailException();
        }

        if (!ticket.isInParking()) {
            throw new TicketHasBeenUsedPickingFailException();
        }

        Car car = parkedCars.get(ticket);
        ticket.pick();

        return car;
    }

    public boolean ContainsTicket(Ticket ticket) {
        return parkedCars.containsKey(ticket);
    }

    public boolean hasFreeParking() {
        return ParkingCarAmount() < capacity;
    }

    public int freeSpaceAmount() {
        return capacity - ParkingCarAmount();
    }

    private int ParkingCarAmount() {
        return (int) parkedCars.keySet().stream().filter(Ticket::isInParking).count();
    }
}