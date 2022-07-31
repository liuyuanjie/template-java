package org.oobootcamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    int capability;
    HashMap<Ticket, Car> parkedCars = new HashMap<>();

    public ParkingLot(int capability) {
        this.capability = capability;
    }

    ParkResult park(Car car) {
        if (getFreeCapability() >= capability) {
            return new ParkResult(null);
        }

        var ticket = new Ticket();
        parkedCars.put(ticket, car);

        return new ParkResult(ticket);
    }

    public PickResult pick(Ticket ticket) {
        if (!parkedCars.containsKey(ticket)) {
            return new PickResult(null, "Invalid ticket");
        }

        Car car = parkedCars.get(ticket);
        if (car.hasBeenPicked) {
            return new PickResult(null, "This ticket has been used, the car has been picked");
        }

        car.pickCar();
        return new PickResult(car, "Pick successfully");
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
