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
        final int rows = scn.nextInt();

        System.out.println("Enter the number of seats in each row: ");
        final int seatsPerRow = scn.nextInt();

        String[][] screenRoom = new String[rows][seatsPerRow];
        for (String[] row : screenRoom) {
            Arrays.fill(row, "S");
        }

//        for (int i = 0; i < screenRoom.length; i++) {
//            for (int j = 0; i < screenRoom[i].length; j++) {
//                screenRoom[i][j] = "S";
//            }
//        }

        boolean exit = false;
        do {
            int option = displayMenuAndGetInput();
            switch (option) {
                case 1:
                    displaySeatings(screenRoom);
                    break;

                case 2:
                    buyTicket(screenRoom);
                    break;

                case 0:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option entered! Try again");
                    break;
            }
        } while(!exit);
    }

    private static int displayMenuAndGetInput() {
        System.out.println();

        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");

        int option = scn.nextInt();
        return option;
    }

    private static void displaySeatings(String[][] screenRoom) {
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
    }

    private static void buyTicket(String[][] screenRoom) {
        System.out.println();

        System.out.println("Enter a row number: ");
        int seatRow = scn.nextInt();

        System.out.println("Enter a seat number in that row: ");
        int seatCol = scn.nextInt();

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
        // Mark the purchased ticket as occupied in the "screenRoom" seating arrangement
        screenRoom[seatRow - 1][seatCol - 1] = "B";
    }
}