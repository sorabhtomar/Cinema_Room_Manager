class ArrayOperations {
    public static void printCorners(int[][] arr) {
        // tl: top left, tr: top right
        // bl: bottom left, br: bottom right
        int tl = 0;
        int tr = 0;
        int bl = 0;
        int br = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0 && j == 0) {
                    tl = arr[i][j];
                }
                else if (i == 0 && j == arr[i].length - 1) {
                    tr = arr[i][j];
                }
                else if (i == arr.length - 1 && j == 0) {
                    bl = arr[i][j];
                }
                else if (i == arr.length - 1 && j == arr[i].length - 1) {
                    br = arr[i][j];
                }
            }
        }

        System.out.println(tl + " " + tr);
        System.out.println(bl + " " + br);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1},
                {2},
                {3}
        };
        printCorners(arr);
    }
}