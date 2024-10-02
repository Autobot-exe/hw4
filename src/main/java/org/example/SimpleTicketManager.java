package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SimpleTicketManager implements TicketManager {

    private final List<Ticket> tickets = new ArrayList<>();

    @Override
    public void add(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public Ticket next() {
        if (tickets.isEmpty()) {
            return null;
        }

        tickets.sort(Comparator.comparing((Ticket t) -> t.type.equals("pension") ? 0 : 1)
                .thenComparing(t -> t.registerTime));

        return tickets.remove(0);
    }
}