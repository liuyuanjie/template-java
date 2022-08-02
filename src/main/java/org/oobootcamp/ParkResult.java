package org.oobootcamp;

import org.oobootcamp.status.ParkStatus;

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
}