package org.oobootcamp;

public class ParkResult
{
    Ticket _ticket;

    public ParkResult(Ticket ticket) {
        _ticket = ticket;
    }

    public boolean HasTicket() {
        return _ticket != null;
    }
}
