// KNIGHT'S TOUR
//Given a N*N board with the Knight placed on the first block of an empty board. Moving according to the rules of chess, knights must visit each square exactly once. 
//Print the order of each cell in which they are visited.

public class Knight_Tour {

    static int N = 8;

    public static boolean isSafe(int x, int y, int sol[][]) {
        return ( x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    public static void printSolution(int sol[][]) {
        for(int x = 0; x < N; x++){
            for(int y = 0; y < N; y++){
                System.out.print(sol[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solveKT() {
        int sol[][] = new int[8][8];
        for(int x = 0; x < N; x++) {
            for(int y = 0; y < N; y++) {
                sol[x][y] = -1;
            }
        }
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // As the Knight starts from cell(0,0)
        sol[0][0] = 0;

        if(!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution doesn't exist");
            return false;
        } else{
            printSolution(sol);
        }
        return true;
    }

    public static boolean solveKTUtil(int x, int y, int movei, int sol[][], int xMove[], int yMove[]) {
        int k, next_x, next_y;
        if(movei == N * N){
            return true;
        }
        for(k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if(isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if(solveKTUtil(next_x, next_y, movei + 1, sol, xMove, yMove)) {
                    return true;
                }
                else {
                    sol[next_x][next_y] = -1; // Backtracking
                }
            }
        }
        return false;
    }
    public static void main(String args[]) {
        solveKT();
    }
}
