package com.mateuszgebka.tombola;

import java.security.SecureRandom;
import java.util.*;

public class TicketGenerator {

    private final SecureRandom secureRandom;
    private final List<Integer> allColumns;
    private final List<List<Integer>> allValues;

    public TicketGenerator() {
        this.secureRandom = new SecureRandom();
        this.allColumns = initializeColumns();
        this.allValues = initializeAllValues();
    }

    public Set<Ticket> getTicketsSet(int numOfTickets) {
        Set<Ticket> ticketDb = new HashSet<>();

        for (int i = 0; i < numOfTickets; i++) {
            Ticket ticket = this.generateTicket();

            while (ticketDb.contains(ticket)) {
                System.out.println("This ticket already exists! Generating new...");
                ticket = this.generateTicket();
            }

            ticketDb.add(ticket);
        }

        return ticketDb;
    }

    /// Generate Tombola Ticket
    /// Rules of placing values:
    /// - exactly 15 different values on each ticket
    /// - exactly 5 values in each row
    /// - min. 5 different columns
    /// - each column has its own set of values that can be selected
    public Ticket generateTicket() {
        List<Integer> randomColumns = generateRandomColumns();
        List<List<Integer>> rejectedFields = getFieldsToReject(randomColumns);

        // Data to return
        HashMap<Integer, Map<Integer, Integer>> ticketData = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            if (randomColumns.contains(i)) {
                // Get values available in specific column (e.g. 0 -> 1-10, 1 -> 11-20, etc.)
                List<Integer> valuesInColumn = new ArrayList<>(allValues.get(i));

                int rejectedFieldsCounter = 0;
                for (List<Integer> row : rejectedFields) {
                    if (row.contains(i)) rejectedFieldsCounter++;
                }

                if (rejectedFieldsCounter < 3) {
                    Collections.shuffle(valuesInColumn, secureRandom);
                    List<Integer> rows = new ArrayList<>(List.of(0, 1, 2));
                    Collections.shuffle(rows, secureRandom);

                    final int elementsInColumn = 3 - rejectedFieldsCounter;

                    List<Integer> values = valuesInColumn.subList(0, elementsInColumn);
                    rows = rows.subList(0, elementsInColumn);

                    Map<Integer, Integer> valuesInRow = new HashMap<>();

                    for (int j = 0; j < elementsInColumn; j++) {
                        valuesInRow.put(rows.get(j), values.get(j));
                    }



                    ticketData.put(i, valuesInRow);
                }
            }
        }

        return new Ticket(ticketData);
    }

    /// Initialize all ticket's columns [0..8]
    private List<Integer> initializeColumns() {
        List<Integer> columns = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            columns.add(i);
        }

        return columns;
    }

    ///  Initialize all available values [1-90] that can be written
    ///  in specific columns on the ticket (1 -> 1..10, 2 -> 11..20, etc.)
    private List<List<Integer>> initializeAllValues() {
        List<List<Integer>> availableNumbers = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 1; j <= 10; j++) {
                col.add(10 * i + j);
            }
            availableNumbers.add(col);
        }

        return availableNumbers;
    }

    /// Generate random count (min. 5) of random columns (0..8), e.g.
    /// 5 cols -> {0, 3, 4, 7, 8}
    /// 6 cols -> {0, 2, 3, 5, 6, 8}
    /// which will be filled by values while generating the ticket
    private List<Integer> generateRandomColumns() {
        List<Integer> columnsCopy = new ArrayList<>(allColumns);
        Collections.shuffle(columnsCopy, secureRandom);

        int randomColumnsCount = secureRandom.nextInt(5, 10);

        List<Integer> chosenColumns = columnsCopy.subList(0, randomColumnsCount);
        Collections.sort(chosenColumns);

        return chosenColumns;
    }

    /// Generate fields to be rejected in every ticket's row, e.g.
    /// Ticket has values in 6 columns -> reject 1 random column in every row
    /// Ticket has values in every column (9 columns) -> reject 4 random columns in every row
    private List<List<Integer>> getFieldsToReject(List<Integer> colsInGame) {
        List<Integer> copyOfCols = new ArrayList<>(colsInGame);
        List<List<Integer>> fieldsToReject = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Collections.shuffle(copyOfCols, secureRandom);
            List<Integer> row = new ArrayList<>(copyOfCols.subList(0, copyOfCols.size() - 5));
            Collections.sort(row);
            fieldsToReject.add(row);
        }

        return fieldsToReject;
    }
    
    

}
