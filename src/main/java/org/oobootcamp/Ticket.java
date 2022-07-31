package org.oobootcamp;

import java.util.UUID;

public class Ticket {
    UUID ticketNo;

    public Ticket() {
        ticketNo = UUID.randomUUID();
    }
}
