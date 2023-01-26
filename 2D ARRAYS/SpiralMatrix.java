public class SpiralMatrix {

    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <= endCol){
            //top boundary - here, row is fixed starting row, but col is moving from startcol to endcol
            for(int j = startCol; j <= endCol; j++){ //i is for row and j is for column
                System.out.print(matrix[startRow][j]+" ");
            }
            
            //right - here, col is fixed and row is changing
            for(int i = startRow+1; i <= endRow; i++){
                System.out.print(matrix[i][endCol]+" ");
            }

            //bottom
            for(int j = endCol-1; j >= startCol; j--){
                if (startRow == endRow){ //in cases of odd, so we have already printed it in top, so we don't need to repeat it here
                    break; // in case when only one cell is printed, then bottom and left should be avoided since the cell will print same value already at top and right
                }
                System.out.print(matrix[endRow][j]+" ");
            }

            //left
            for(int i = endRow-1; i >= startRow+1; i--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(matrix[i][startCol]+" ");
            }

            // update all 4 variables
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        System.out.println();
    }
    public static void main(String args[]) {
        int matrix[][] = {{1, 2, 3, 4},
                          {5, 6, 7, 8},
                          {9, 10, 11, 12},
                          {13, 14, 15, 16}};
        
        printSpiral(matrix);
    }
}
