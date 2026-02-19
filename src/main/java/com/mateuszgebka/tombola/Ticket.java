package com.mateuszgebka.tombola;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Ticket {
    private final Map<Integer, Map<Integer, Integer>> columns;

    public Ticket(Map<Integer, Map<Integer, Integer>> columns) {
        this.columns = columns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(columns, ticket.columns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columns);
    }

    public void printTicket() {
        for (Map.Entry<Integer, Map<Integer, Integer>> col : columns.entrySet()) {
            System.out.println("---");
            System.out.println("Col " + col.getKey() + ":");

            for (Map.Entry<Integer, Integer> row : col.getValue().entrySet()) {
                System.out.println("\tRow " + row.getKey() + " -> " + row.getValue());
            }
        }
    }

    public int getNumOfColumns() {
        return this.columns.size();
    }
}
