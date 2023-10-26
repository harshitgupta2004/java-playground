import java.util.*;

public class TwoDArrays {

    // Search an element in 2d array
    public static boolean search(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("Found at cell (" + i + " , " + j + ")");
                    return true;
                }
            }
        }
        System.out.println("Key Not Found");
        return false;
    }

    public static void main(String agrs[]) {
        int matrix[][] = new int[3][3];
        int n = matrix.length, m = matrix[0].length; // n - rows; m - columns
        // matrix[0] will give us our 1st row and we will find its total length, that
        // will give us total no of cols

        // elements input
        Scanner sc = new Scanner(System.in);
        // firstly we go with 1st row, then its 1st col, then 2nd col of 1st and so on
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // output
        for (int i = 0; i < n; i++) { // row wise travel
            for (int j = 0; j < m; j++) { // columns wise travel
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // search
        search(matrix, 9);
    }
}
