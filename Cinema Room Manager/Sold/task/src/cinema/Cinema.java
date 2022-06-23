package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // srCost: screen room seat cost
        final int srCost = 10;
        // lrCostFh: large room seat cost, front half
        final int lrCostFh = 10;
        // lrCostBh: large room seat cost, back half
        final int lrCostBh = 8;

        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        final int rows = scn.nextInt();

        System.out.println("Enter the number of seats in each row: ");
        final int seatsPerRow = scn.nextInt();

        System.out.println("Total income: ");

        int totalSeats = rows * seatsPerRow;
        int profit = 0;
        if (totalSeats <= 60) {
            // screen room
            profit = totalSeats * srCost;
        } else {
            // larger room

            // fhRows: front half total rows
            int fhRows = rows / 2;
            // bhRows: back half total rows
            int bhRows = rows - fhRows;

            profit = fhRows * seatsPerRow * lrCostFh + bhRows * seatsPerRow * lrCostBh;
        }

        System.out.println("$" + profit);
    }
}