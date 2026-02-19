package com.mateuszgebka.tombola;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        TicketGenerator generator = new TicketGenerator();

        Set<Ticket> ticketDb = new HashSet<>();

        for (int i = 0; i < 2_000_000; i++) {
            Ticket ticket = generator.generateTicket();

            while (ticketDb.contains(ticket)) {
                System.out.println("This ticket already exists! Generating new...");
                ticket = generator.generateTicket();
            }

            ticketDb.add(ticket);
        }

        // Show tickets
        int i = 1;
        for (Ticket t : ticketDb) {
            System.out.println("Ticket #" + i++);
            t.printTicket();
            System.out.println("----------");
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        System.out.println("Execution time:");
        System.out.println(duration + " nanoseconds");
        System.out.println(duration / 1_000_000 + " miliseconds");
    }
}
