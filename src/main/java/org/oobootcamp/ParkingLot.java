package org.oobootcamp;

import org.oobootcamp.status.ParkStatus;
import org.oobootcamp.status.PickStatus;

import java.util.HashMap;

public class ParkingLot {
    private int totalParkingAmount;
    private HashMap<Ticket, Car> parkedCars = new HashMap<>();
    private String name;

    public ParkingLot(int parkingAmount) {
        this.totalParkingAmount = parkingAmount;
    }

    public ParkingLot(String name, int parkingAmount) {
        this.name = name;
        this.totalParkingAmount = parkingAmount;
    }

    ParkResult park(Car car) {
        if (!HasFreeParking()) {
            return new ParkResult(ParkStatus.FAILURE);
        }

        car.park();

        var ticket = new Ticket(this);
        parkedCars.put(ticket, car);

        return new ParkResult(ticket, ParkStatus.SUCCESS);
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

    public String getName() {
        return name;
    }

    private boolean HasFreeParking() {
        int inPackingAmount = (int) parkedCars.values().stream().filter(x -> !x.hasPicked()).count();

        return inPackingAmount < totalParkingAmount;
    }
}