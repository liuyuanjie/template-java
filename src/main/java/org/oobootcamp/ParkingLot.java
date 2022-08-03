package org.oobootcamp;

import org.oobootcamp.status.ParkStatus;
import org.oobootcamp.status.PickStatus;

import java.util.HashMap;

public class ParkingLot {
    private int capacity;
    private HashMap<Ticket, Car> parkedCars = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkResult park(Car car) {
        if (!hasFreeParking()) {
            return new ParkResult(ParkStatus.FAILURE);
        }

        var ticket = new Ticket();
        parkedCars.put(ticket, car);
        ticket.park();

        return new ParkResult(ticket, ParkStatus.SUCCESS);
    }

    public PickResult pick(Ticket ticket) {
        if (!parkedCars.containsKey(ticket)) {
            return new PickResult(PickStatus.INVALID_TICKET);
        }

        if (!ticket.isInParking()) {
            return new PickResult(PickStatus.EXPIRED_TICKET);
        }

        Car car = parkedCars.get(ticket);
        ticket.pick();

        return new PickResult(car, PickStatus.VALID_TICKET);
    }

    private boolean hasFreeParking() {
        return hasParkedSpaces() < capacity;
    }

    public int freeSpace() {
        return capacity - hasParkedSpaces();
    }

    private int hasParkedSpaces() {
        return (int) parkedCars.keySet().stream().filter(ticket -> ticket.isInParking()).count();
    }
}