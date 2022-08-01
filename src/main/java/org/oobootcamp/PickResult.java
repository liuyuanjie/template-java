package org.oobootcamp;

import org.oobootcamp.Status.PickStatus;

import static org.oobootcamp.Constants.*;

public class PickResult {
    private Car car;
    private PickStatus pickStatus;

    public PickResult(PickStatus pickStatus)
    {
        this.pickStatus = pickStatus;
    }

    public PickResult(Car car, PickStatus pickStatus)
    {
        this.car = car;
        this.pickStatus = pickStatus;
    }

    public Car getCar(){
        return car;
    }

    public String getMessage() {
        switch (pickStatus) {
            case INVALID_TICKET -> {
                return INVALID_TICKET_THE_CAR_CAN_NOT_BE_FOUND;
            }
            case EXPIRED_TICKET -> {
                return THIS_TICKET_HAS_EXPIRED_THE_CAR_HAS_BEEN_PICKED;
            }
            default -> {
                return PICK_SUCCESSFULLY;
            }
        }
    }

    public boolean isSuccess() {
        return this.pickStatus == PickStatus.VALID_TICKET;
    }

    public boolean isParkingLotTicket(){
        return pickStatus == PickStatus.VALID_TICKET || pickStatus == PickStatus.EXPIRED_TICKET;
    }
}
