package org.oobootcamp;

import java.util.HashMap;

public class ParkingLot {
    int capability = 0;
    HashMap<Ticket, Car> parkedCars;

    {
        parkedCars = new HashMap<>();
    }

    public ParkingLot(int capability) {
        this.capability = capability;
    }

    ParkResult park(Car car)
    {
        if(remaindingCapability() >= capability)
        {
            return new ParkResult(null);
        }

        var ticket = new Ticket();
        parkedCars.put(ticket, car);
        return new ParkResult(ticket);
    }

    public PickResult pick(Ticket ticket)
    {
        if(parkedCars.containsKey(ticket))
        {
            Car car = parkedCars.get(ticket);
            if(car.hasBeenPicked)
            {
                return new PickResult(null);
            }

            car.pickCar();
            return new PickResult(car);
        }

        return new PickResult(null);
    }

    private int remaindingCapability()
    {
        int count = 0;

      for (Car car : parkedCars.values())
      {
          if(car.hasBeenPicked)
              continue;

          count++;
      }

      return count;
    }
}
