package com.mateuszgebka.tombola;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

public class TicketGeneratorTest {

    @Test
    public void shouldGenerateCorrectNumberOfTickets() {
        TicketGenerator generator = new TicketGenerator();

        Set<Ticket> ticketDb = generator.getTicketsSet(20);

        assertEquals(20, ticketDb.size(), "Generator should produce exatly 20 tickets!");
    }
}
