package com.mateuszgebka.tombola;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static void main() {


        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number of tickets to generate: ");
            int numOfTickets = scanner.nextInt();

            if (numOfTickets > 0) {
                long startTime = System.nanoTime();
                TicketGenerator generator = new TicketGenerator();

                Set<Ticket> ticketDb = generator.getTicketsSet(numOfTickets);

                // Show tickets
                int i = 1;
                for (Ticket t : ticketDb) {
                    System.out.println("Ticket #" + i++);
                    System.out.println("Columns count: " + t.getNumOfColumns());
                    t.printTicket();
                    System.out.println("----------");
                }

                long endTime = System.nanoTime();
                long duration = (endTime - startTime);

                System.out.println("Execution time:");
                System.out.println(duration + " nanoseconds");
                System.out.println(duration / 1_000_000 + " miliseconds");

            } else {
                System.out.println("Enter valid count of tickets.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
