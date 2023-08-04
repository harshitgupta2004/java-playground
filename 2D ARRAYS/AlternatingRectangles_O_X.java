/* Write a code which inputs two numbers m and n and creates a matrix of size m x n (m rows and n columns) in which every elements is either X or 0. The Xs and 0s must be filled alternatively, the matrix should have outermost rectangle of Xs, then a rectangle of 0s, then a rectangle of Xs, and so on */

// TC = SC = O(nm) 

public class AlternatingRectangles_O_X {
    public static void fill0X (int m, int n){
        int startRow = 0;
        int startCol = 0;
        int endRow = m;
        int endCol = n;
        int r = endRow, c = endCol;
        char[][] matrix = new char[m][n];

        // Initialize the character to be stored in matrix[][]
        char x = 'X';

        while(startRow < endRow && startCol < endCol){
            //top boundary - here, row is fixed starting row, but col is moving from startcol to endcol
            for(int j = startCol; j < endCol; j++){ //i is for row and j is for column
                matrix[startRow][j] = x;
            }
            startRow++;
            
            //right - here, col is fixed and row is changing
            for(int i = startRow; i < endRow; i++){
                matrix[i][endCol-1] = x;
            }
            endCol--;

            //bottom
            if(startRow < endRow){
                for(int j = endCol-1; j >= startCol; j--){
                    matrix[endRow-1][j] = x;
                }
                endRow--;
            }
            

            //left
            if(startCol < endCol){
                for(int i = endRow-1; i >= startRow; i--){
                    matrix[i][startCol] = x;
                }
                startCol++;
            }

            // Flip character for next iteration
            x = (x == '0') ? 'X' :'0';
        }

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("Output for m = 5, n = 6");
        fill0X(5, 6);
 
        System.out.println("Output for m = 4, n = 4");
        fill0X(4, 4);
 
        System.out.println("Output for m = 3, n = 4");
        fill0X(3, 4);
    }
}
