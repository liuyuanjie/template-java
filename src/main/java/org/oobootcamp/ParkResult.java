package org.oobootcamp;

public class ParkResult {
    Ticket ticket;
    String message;

    public ParkResult(Ticket ticket) {
        if (ticket == null) {
            message = "Parking lot is full, parking failed.";
        }
        this.ticket = ticket;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public String message() {
        return message;
    }
}
