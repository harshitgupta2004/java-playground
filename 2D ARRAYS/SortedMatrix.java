public class SortedMatrix {

    public static boolean staircaseSearch(int matrix[][], int key) {
        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Found Key at (" + row + "," + col + ")");
                return true;
            }

            else if (key < matrix[row][col]) {
                col--; // key < cellvalue - move LEFT
            } else {
                row++; // key > cellvalue - move bottom
            }
        }
        System.out.println("Key not found!");
        return false; // if key not found, eturn false statemnt
    }

    public static void main(String args[]) {
        int matrix[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };
        int key = 33;
        staircaseSearch(matrix, key);
    }
}
