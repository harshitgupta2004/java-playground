// TCC = O(n*m) SC = O(1)

/* Given a matrix where every element is either ‘O’ or ‘X’, replace ‘O’ with ‘X’ if surrounded by ‘X’. A ‘O’ (or a set of ‘O’) is considered to be by surrounded by ‘X’ if there are ‘X’ at locations just below, just above, just left and just right of it */

public class OX_Replace {
    public static char[][] fill(int n, int m, char[][] mat){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if((i == 0 || j == 0 || i == n-1 || j == m-1) && mat[i][j] == 'O'){
                    dfs(i, j, n, m, mat);
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 'O'){
                    mat[i][j] = 'X';
                }else if(mat[i][j] == '$'){
                    mat[i][j] = 'O';
                }
            }
        }

        return mat;
    }

    public static void dfs(int i, int j, int n, int m, char[][] mat){
        if(i < 0 || j < 0 || i >= n || j >= m || mat[i][j] == 'X'){
            return;
        }

        if(mat[i][j] == 'O'){
            mat[i][j] = '$';
            dfs(i+1, j, n, m, mat);
            dfs(i-1, j, n, m, mat);
            dfs(i, j+1, n, m, mat);
            dfs(i, j-1, n, m, mat);
        }
    }
    
    public static void main(String[] args) {
        char[][] mat = {{ 'X', 'O', 'X', 'O', 'X', 'X' },
                        { 'X', 'O', 'X', 'X', 'O', 'X' },
                        { 'X', 'X', 'X', 'O', 'X', 'X' },
                        { 'O', 'X', 'X', 'X', 'X', 'X' },
                        { 'X', 'X', 'X', 'O', 'X', 'O' },
                        { 'O', 'O', 'X', 'O', 'O', 'O' }};
 
        int n = mat.length;
        int m = mat[0].length;
        fill(n, m, mat);
 
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
