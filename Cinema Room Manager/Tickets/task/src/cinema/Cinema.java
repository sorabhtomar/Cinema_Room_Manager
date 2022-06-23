package cinema;

import java.util.Scanner;
import java.util.Arrays;

public class Cinema {

    // SSR_COST: small screen room seat cost
    private static final int SSR_COST = 10;

    // LSR_COST_FH: large screen room seat cost, front half
    private static final int LSR_COST_FH = 10;

    // LSR_COST_BH: large screen room seat cost, back half
    private static final int LSR_COST_BH = 8;

    private static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the number of rows: ");
        int rows = scn.nextInt();

        System.out.println("Enter the number of seats in each row: ");
        int seatsPerRow = scn.nextInt();

        String[][] screenRoom = new String[rows][seatsPerRow];
        for (String[] row : screenRoom) {
            Arrays.fill(row, "S");
        }

        display(screenRoom);

        System.out.println("Enter a row number: ");
        int seatRow = scn.nextInt();

        System.out.println("Enter a seat number in that row: ");
        int seatCol = scn.nextInt();

        displayTicketPrice(screenRoom, seatRow);
        display(screenRoom, seatRow, seatCol);
    }

    private static void display(String[][] screenRoom, int seatRow, int seatCol) {
        screenRoom[seatRow - 1][seatCol - 1] = "B";
        display(screenRoom);
        screenRoom[seatRow - 1][seatCol - 1] = "S";
    }

    private static void display(String[][] screenRoom) {
        System.out.println();

        System.out.println("Cinema:");

        int row = 1;
        for (int i = 0; i <= screenRoom[0].length; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(row++ + " ");
            }
        }
        System.out.println();

        for (int i = 0; i < screenRoom.length; i++) {
            for (int j = 0; j < screenRoom[i].length; j++) {
                if (j == 0) {
                    System.out.print((i + 1) + " ");
                }

                System.out.print(screenRoom[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    private static void displayTicketPrice(String[][] screenRoom, int seatRow) {
        System.out.println();

        int rows = screenRoom.length;
        int seatsPerRow = screenRoom[0].length;

        int totalSeats = rows * seatsPerRow;

        int price = 0;
        if (totalSeats <= 60) {
            // small screen room
            price = SSR_COST;
        } else {
            // larger screen room
            // fhRows: front half total rows
            int fhRows = rows / 2;
            // bhRows: back half total rows
            int bhRows = rows - fhRows;

            if(seatRow <= fhRows) {
                price = LSR_COST_FH;
            } else {
                price = LSR_COST_BH;
            }
        }

        System.out.println("Ticket price: $" + price);
    }
}