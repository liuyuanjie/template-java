package org.oobootcamp;

public class PickResult {
    Car car ;
    public PickResult(Car car)
    {
        this.car =car;
    }

    public boolean isSuccess()
    {
        return this.car != null ;
    }
}
