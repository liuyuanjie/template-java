package org.oobootcamp;

import org.oobootcamp.status.CarStatus;

public class Car {
    private CarStatus carStatus;

    public void pick()
    {
        carStatus = CarStatus.PICKED;
    }

    public void park()
    {
        carStatus = CarStatus.IN_PARKING;
    }

    public boolean hasPicked(){
        return carStatus == CarStatus.PICKED;
    }
}
