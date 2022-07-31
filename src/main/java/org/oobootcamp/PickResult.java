package org.oobootcamp;

public class PickResult {
    Car car;
    String message;

    public PickResult(Car car, String message)
    {
        this.car = car;
        this.message = message;
    }

    public boolean isSuccess() {
        return this.car != null;
    }
}
