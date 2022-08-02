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

    ParkResult park(Car car) {
        if (!HasFreeParking()) {
            return new ParkResult(ParkStatus.FAILURE);
        }

        car.park();

        var ticket = new Ticket();
        parkedCars.put(ticket, car);

        return new ParkResult(ticket, ParkStatus.SUCCESS);
    }

    public PickResult pick(Ticket ticket) {
        if (!parkedCars.containsKey(ticket)) {
            return new PickResult(PickStatus.INVALID_TICKET);
        }

        Car car = parkedCars.get(ticket);
        if (!car.GetInPacking()) {
            return new PickResult(PickStatus.EXPIRED_TICKET);
        }

        car.pick();

        return new PickResult(car, PickStatus.VALID_TICKET);
    }

    private boolean HasFreeParking() {
        int inPackingAmount = (int) parkedCars.values().stream().filter(x -> x.GetInPacking()).count();

        return inPackingAmount < capacity;
    }

    public int remaindingSpace() {
        int inPackingAmount = (int) parkedCars.values().stream().filter(x -> x.GetInPacking()).count();

        return capacity - inPackingAmount ;
    }
}