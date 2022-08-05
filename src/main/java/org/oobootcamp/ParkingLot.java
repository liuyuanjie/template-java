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

    Ticket park(Car car) throws ParkFailException {
        if (!HasFreeParking()) {
         throw new ParkFailException("Park failed. Parking lot is full.");
        }

        car.park();

        var ticket = new Ticket();
        parkedCars.put(ticket, car);

        return ticket;
    }

    public Car pick(Ticket ticket) throws PickFailException {
        if (!parkedCars.containsKey(ticket)) {
            throw new PickFailException("Pick failed. Invalid ticket.");
        }

        Car car = parkedCars.get(ticket);
        if (!car.ISCarInParking()) {
            throw new PickFailException("Pick failed. ticket has been used.");
        }

        car.pick();

        return car;
    }

    public boolean ContainsTicket(Ticket ticket)
    {
        return parkedCars.containsKey(ticket);

    }

    public boolean HasFreeParking() {
        return ParkingCarCount() < capacity;
    }

    public int remaindingSpace() {
        return capacity - ParkingCarCount() ;
    }

    private int ParkingCarCount()
    {
        return (int) parkedCars.values().stream().filter(x -> x.ISCarInParking()).count();
    }
}