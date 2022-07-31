package org.oobootcamp;

public class PickResult {
    Car car;
    PickCarStatus pickCarStatus;

    public PickResult(PickCarStatus pickCarStatus)
    {
        this.pickCarStatus = pickCarStatus;
    }

    public PickResult(Car car, PickCarStatus pickCarStatus)
    {
        this.car = car;
        this.pickCarStatus = pickCarStatus;
    }

    public String getMessage() {
        switch (pickCarStatus) {
            case InvalidTicket -> {
                return "Invalid ticket";
            }
            case ExpiredTicket -> {
                return "This ticket has been used, the car has been picked";
            }
            default -> {
                return "Pick successfully";
            }
        }
    }

    public boolean isSuccess() {
        return this.car != null;
    }

    public boolean isParkingLotTicket(){
        return pickCarStatus == PickCarStatus.Success || pickCarStatus == PickCarStatus.ExpiredTicket;
    }
}
