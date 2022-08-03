package org.oobootcamp;

public class Car {
    private boolean inParking;

    public void pick() {
        inParking = false;
    }

    public void park() {
        inParking = true;
    }

    public boolean isInParking() {
        return inParking;
    }
}
