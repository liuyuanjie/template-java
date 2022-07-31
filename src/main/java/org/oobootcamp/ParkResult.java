package org.oobootcamp;

import static org.oobootcamp.Constants.PACK_SUCCESSFULLY;
import static org.oobootcamp.Constants.PARKING_LOT_WAS_FULL_FAILED_TO_PACK;

public class ParkResult {
    private Ticket ticket;

    public ParkResult() {
    }

    public ParkResult(Ticket ticket) {
        this.ticket = ticket;
    }

    public boolean isSuccess() {
        return ticket != null;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String getMessage() {
        return ticket == null ? PARKING_LOT_WAS_FULL_FAILED_TO_PACK : PACK_SUCCESSFULLY;
    }
}
