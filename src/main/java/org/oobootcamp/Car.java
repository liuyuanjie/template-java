package org.oobootcamp;

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
