import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] rotated = new int[m][n];

        // rotate (by 90 degree, clockwise) = (transpose of matrix) + (reverse elements)

        // transpose of matrix "arr"
        transpose(arr, rotated);

        // reversing elements in each row of "rotated"
        for (int[] row : rotated) {
            reverseRowElements(row);
        }

        // display "rotated" array
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated[i].length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void transpose(int[][] arr, int[][] rotated) {
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated[i].length; j++) {
                rotated[i][j] = arr[j][i];
            }
        }
    }

    private static void reverseRowElements(int[] row) {
        int i = 0;
        int j = row.length - 1;

        while (i < j) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;

            i++;
            j--;
        }
    }
}