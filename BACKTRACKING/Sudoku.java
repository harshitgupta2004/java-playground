public class Sudoku {

    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // Column condition
        for(int i = 0; i <= 8; i++) {
            if(sudoku[i][col] == digit) {
                return false;
            }
        }

        // Row condition
        for(int j = 0; j <= 8; j++) {
            if(sudoku[row][j] == digit) {
                return false;
            }
        }

        // Grid conition
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;

        // Traversing in a 2d array - 3x3 grid
        for(int i = sr; i < sr+3; i++) { // row wise travel in 3x3 grid
            for(int j = sc; j < sc+3; j++) { //col wise travel
                if(sudoku[i][j] == digit) {
                    return false;
                }
            } 
        }

        return true; // means it is safe to place digit in that cell
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // Base case
        if(row == 9) { //When the row becomes 9, my sudoku completes and we will get the solution
            return true;
        }
        
        // Recursion
        int nextRow = row, nextCol = col+1; // Everytime, in same row, we are increasing the col
        if(col+1 == 9) { // Row will increase when we reach the end col of sudoku
            nextRow = row+1; 
            nextCol = 0; //in next row, we will again start from 0th col
        }

        // This condition is for already set elements
        if(sudoku[row][col] != 0) { //When there is already a digit present in the cell 
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        // This condition is for those elements we have to place in the new cell
        for(int digit = 1; digit <= 9; digit++) { // try to place this digit in (row,col) cell everytime
            if(isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit; //Place this digit into sudoku
                if(sudokuSolver(sudoku, nextRow, nextCol)) { //Soln exists if it returns true
                    return true;
                } 
                sudoku[row][col] = 0; // that in this, we do not want to place our digit
            }
        }

        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int sudoku[][] = { {0, 0, 8, 0, 0, 0, 0, 0, 0},
                           {4, 9, 0, 1, 5, 7, 0, 0, 2},
                           {0, 0, 3, 0, 0, 4, 1, 9, 0},
                           {1, 8, 5, 0, 6, 0, 0, 2, 0},
                           {0, 0, 0, 0, 2, 0, 0, 6, 0},
                           {9, 6, 0, 4, 0, 5, 3, 0, 0},
                           {0, 3, 0, 0, 7, 2, 0, 0, 4},
                           {0, 4, 9, 0, 3, 0, 0, 5, 7},
                           {0, 2, 7, 0, 0, 9, 0, 1, 3} };

        if(sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exists");
            printSudoku(sudoku);
        } else {
            System.out.println("Solution doesn't exist");
        }
    }
}
