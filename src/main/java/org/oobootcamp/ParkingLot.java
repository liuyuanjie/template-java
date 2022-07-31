package org.oobootcamp;

import java.util.HashMap;

public class ParkingLot {
    int capability;
    HashMap<Ticket, Car> parkedCars = new HashMap<>();
    String name;

    public ParkingLot(int capability) {
        this.capability = capability;
    }

    public ParkingLot(String name, int capability) {
        this.name = name;
        this.capability = capability;
    }

    ParkResult park(Car car) {
        if (HasFreeParkingPlace()) {
            return new ParkResult(null);
        }

        var ticket = new Ticket(this);
        parkedCars.put(ticket, car);

        return new ParkResult(ticket);
    }

    public boolean HasFreeParkingPlace() {
        return getFreeCapability() >= capability;
    }

    public PickResult pick(Ticket ticket) {
        if (!parkedCars.containsKey(ticket)) {
            return new PickResult(PickCarStatus.InvalidTicket);
        }

        Car car = parkedCars.get(ticket);
        if (car.hasBeenPicked) {
            return new PickResult(PickCarStatus.ExpiredTicket);
        }

        car.pickCar();
        return new PickResult(car, PickCarStatus.Success);
    }

    private int getFreeCapability() {

        int count = 0;

        for (Car car : parkedCars.values()) {
            if (car.hasBeenPicked)
                continue;

            count++;
        }

        return count;
    }
}
