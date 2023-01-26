public class N_Queens {

    public static boolean isSafe(char board[][], int row, int col) { 
        // Vertical up direction -> col same but row-- by 1 upto row == 0
        for(int i = row-1; i >= 0; i--) {
            if(board[i][col] == 'Q') { //UnSafe
                return false;
            }
        }

        // Diagonal Left Up -> everytime, row and col dec by 1 upto one of them becomes 0
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        // Diagonal Right Up -> row dec by 1 but col inc by 1
        for(int i = row-1, j = col+1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][], int row) {
        // base case
        if(row == board.length) {
            printBoard(board);
            count++; //Total ways  //Instead of print, we just increment the count
            return;
        }

        // Column loop -> Place/put n queens in n rows
        for(int j = 0; j < board.length; j++) {

            if(isSafe(board, row, j)) { // Everytime, we will check this isSafe fxn before putting the queen Q to check that whether it is safe or not to put the Q in that position
                board[row][j] = 'Q'; // Meaning we put Q there
                nQueens(board, row+1); //Function Call for next row
                board[row][j] = 'x'; //Backtracking Step // Now, when we BackTrack, we again removed the queen Q from that row; because when we backtrack,
                // we nedd to place Q at new pos in a row, and only 1 Q can sit at a single row. 
                // So, we need to remove the starting Q which we placed from that row, and then it becomes empty pos there.
            }          
        }
    }

    // This modified fxn is for 'Print 1 Solution'
    // public static boolean nQueens(char board[][], int row) {
    //     // base case
    //     if(row == board.length) {
    //         //printBoard(board);
    //         count++; //Total ways  
    //         return true;
    //     }

    //     // Column loop -> Place/put n queens in n rows
    //     for(int j = 0; j < board.length; j++) {

    //         if(isSafe(board, row, j)) { 
    //             board[row][j] = 'Q'; 
    //             if(nQueens(board, row+1)) { // jaise mere n queen ko yahan solution mil gya, usne yhin se return kr diya
    //                 return true;
    //             }
    //             board[row][j] = 'x';  //unplace
    //         }          
    //     }
    //     return false;
    // }

    public static void printBoard(char board[][]) {
        System.out.println("--------Chess Board--------");
        for(int i = 0; i < board.length; i++) {
            for(int j  = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0; //ussi static var ko each level ++ krta rhega

    public static void main(String args[]) {
        int n = 4;
        char board[][] = new char[n][n]; // n x n board

        // Initialize
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = 'x'; // This place is empty
            }
        }


        nQueens(board, 0);
       
        // Count Ways
        System.out.println("Total Ways to solve N Queens Problem: "+ count);

        // Print 1 Solution
        // if(nQueens(board, 0)) {
        //     System.err.println("Solution is possible");
        //     printBoard(board);
        // } else{
        //     System.out.println("Solution is not possible");
        // }
    }
}
