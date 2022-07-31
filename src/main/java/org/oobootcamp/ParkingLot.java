package org.oobootcamp;

import java.util.HashMap;

public class ParkingLot {
    private int totalParkingAmount;
    private HashMap<Ticket, Car> parkedCars = new HashMap<>();
    String name;

    public ParkingLot(int parkingAmount) {
        this.totalParkingAmount = parkingAmount;
    }

    public ParkingLot(String name, int parkingAmount) {
        this.name = name;
        this.totalParkingAmount = parkingAmount;
    }

    ParkResult park(Car car) {
        if (!HasFreeParking()) {
            return new ParkResult();
        }

        car.park();

        var ticket = new Ticket(this);
        parkedCars.put(ticket, car);

        return new ParkResult(ticket);
    }

    public PickResult pick(Ticket ticket) {
        if (!parkedCars.containsKey(ticket)) {
            return new PickResult(PickStatus.INVALID_TICKET);
        }

        Car car = parkedCars.get(ticket);
        if (car.hasPicked()) {
            return new PickResult(PickStatus.EXPIRED_TICKET);
        }

        car.pick();

        return new PickResult(car, PickStatus.VALID_TICKET);
    }

    private boolean HasFreeParking() {
        int inPackingAmount = (int) parkedCars.values().stream().filter(x -> !x.hasPicked()).count();

        return inPackingAmount < totalParkingAmount;
    }
}
