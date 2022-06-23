package cinema;

public class Cinema {

    public static void main(String[] args) {
        final int rows = 7;
        final int seatsPerRow = 8;

        System.out.println("Cinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seatsPerRow; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                } else if (i == 0) {
                    System.out.print(j + " ");
                } else if (j == 0) {
                    System.out.print(i + " ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
    }
}