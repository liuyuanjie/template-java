package org.oobootcamp;

import org.oobootcamp.status.PickStatus;

public class PickResult {
    private Car car;
    private PickStatus pickStatus;

    public PickResult(PickStatus pickStatus) {
        this.pickStatus = pickStatus;
    }

    public PickResult(Car car, PickStatus pickStatus) {
        this.car = car;
        this.pickStatus = pickStatus;
    }

    public Car getCar() {
        return car;
    }

    public boolean isSuccess() {
        return this.pickStatus == PickStatus.VALID_TICKET;
    }

    public boolean isParkingLotTicket() {
        return pickStatus == PickStatus.VALID_TICKET || pickStatus == PickStatus.EXPIRED_TICKET;
    }

    public PickStatus getPickStatus() {
        return this.pickStatus;
    }
}
