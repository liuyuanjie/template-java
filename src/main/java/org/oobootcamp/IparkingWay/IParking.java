package org.oobootcamp.IparkingWay;

import org.oobootcamp.Car;
    import org.oobootcamp.ParkResult;
import org.oobootcamp.ParkingLot;

import java.util.List;

public interface IParking {
    ParkResult park(Car car, List<ParkingLot> parkingLots);
}
