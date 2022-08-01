package org.oobootcamp;

import org.oobootcamp.status.ParkStatus;

import static org.oobootcamp.Constants.PACK_SUCCESSFULLY;
import static org.oobootcamp.Constants.PARKING_LOT_WAS_FULL_FAILED_TO_PACK;

public class ParkResult {
    private Ticket ticket;
    private ParkStatus parkStatus;

    public ParkResult(ParkStatus parkStatus) {
        this.parkStatus = parkStatus;
    }

    public ParkResult(Ticket ticket, ParkStatus parkStatus) {
        this.ticket = ticket;
        this.parkStatus = parkStatus;
    }

    public boolean isSuccess() {
        return this.parkStatus == ParkStatus.SUCCESS;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String getMessage() {
        return isSuccess() ? PACK_SUCCESSFULLY : PARKING_LOT_WAS_FULL_FAILED_TO_PACK;
    }
}