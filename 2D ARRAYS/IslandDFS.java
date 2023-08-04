// TC = SC = O(n*m)

// Given a binary 2D matrix, find the number of islands. A group of connected 1s forms an island

public class IslandDFS {
    public static void dfs(int i, int j, int row, int col, int matrix[][]){
        if(i < 0 || i > row-1 || j < 0 || j > col-1 || matrix[i][j] != 1){
            return;
        }

        if(matrix[i][j] == 1){
            matrix[i][j] = 0;

            dfs(i+1, j, row, col, matrix); // right side traversal
            dfs(i-1, j, row, col, matrix); // left side traversal
            dfs(i, j+1, row, col, matrix); // up side traversal
            dfs(i, j-1, row, col, matrix); // down side traversal

            dfs(i+1, j+1, row, col, matrix); // upward right side traversal
            dfs(i+1, j-1, row, col, matrix); // downward right side traversal
            dfs(i-1, j+1, row, col, matrix); // upward left side traversal
            dfs(i-1, j-1, row, col, matrix); // downward left side traversal
        }
    }

    public static int countIslands(int matrix[][]){
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 1){
                    count++;
                    dfs(i, j, row, col, matrix);
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[][] mat = {{ 1, 1, 0, 0, 0 },
                     { 0, 1, 0, 0, 1 },
                     { 1, 0, 0, 1, 1 },
                     { 0, 0, 0, 0, 0 },
                     { 1, 0, 1, 0, 1 }};
 
        System.out.print("Number of islands is: " + countIslands(mat));
    }
}
