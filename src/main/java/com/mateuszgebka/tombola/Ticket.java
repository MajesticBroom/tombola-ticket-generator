package com.mateuszgebka.tombola;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Ticket {
    private final Map<Integer, List<Integer>> columns;

    public Ticket(Map<Integer, List<Integer>> columns) {
        this.columns = columns;
    }

    public Map<Integer, List<Integer>> getColumns() {
        return columns;
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
        for (List<Integer> col : columns.values()) {
            System.out.println(col);
        }
    }
}
