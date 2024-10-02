package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HomeWork4Test {

    private TicketManager ticketManager;

    @BeforeEach
    void setUp() {
        ticketManager = new SimpleTicketManager();
    }

    @Test
    void testAddAndNextWithPensionTicket() {
        Ticket pensionTicket = new Ticket("pension", OffsetDateTime.now());
        Ticket regularTicket1 = new Ticket("regular", OffsetDateTime.now().plusSeconds(1));
        Ticket regularTicket2 = new Ticket("regular", OffsetDateTime.now().plusSeconds(2));

        ticketManager.add(regularTicket1);
        ticketManager.add(pensionTicket);
        ticketManager.add(regularTicket2);

        assertEquals(pensionTicket, ticketManager.next(), "Next ticket should be the pension ticket.");
        assertEquals(regularTicket1, ticketManager.next(), "Next ticket should be the first regular ticket.");
        assertEquals(regularTicket2, ticketManager.next(), "Next ticket should be the second regular ticket.");
        assertNull(ticketManager.next(), "No more tickets should be available.");
    }

    @Test
    void testAddAndNextWithOnlyRegularTickets() {
        Ticket regularTicket1 = new Ticket("regular", OffsetDateTime.now());
        Ticket regularTicket2 = new Ticket("regular", OffsetDateTime.now().plusSeconds(1));

        ticketManager.add(regularTicket2);
        ticketManager.add(regularTicket1);

        assertEquals(regularTicket1, ticketManager.next(), "Next ticket should be the first added regular ticket.");
        assertEquals(regularTicket2, ticketManager.next(), "Next ticket should be the second added regular ticket.");
        assertNull(ticketManager.next(), "No more tickets should be available.");
    }

    @Test
    void testNextOnEmptyManager() {
        assertNull(ticketManager.next(), "Next ticket should return null when no tickets are available.");
    }
}
