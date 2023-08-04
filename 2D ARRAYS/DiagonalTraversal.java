// TC : O(row x col) & SC : O(1)

public class DiagonalTraversal {
    static final int r = 5;
    static final int c = 4;

    static int min(int a, int b){
        return (a < b) ? a : b;
    }

    
    static int min(int a, int b, int c){
        return min(min(a, b), c);
    }

    static int max(int a, int b){
        return (a < b) ? b : a;
    }

    static void diagonalOrder(int mat[][]){
        // r + c - 1 lines in o/p
        for(int line = 1; line <= (r+c-1); line++){
            int startCol = max(0, line-r);

            // count of elms in this line
            int count = min(line, (c-startCol), r);

            // print elms of this line
            for(int j = 0; j < count; j++){
                System.out.print(mat[min(r, line)-j-1][startCol+j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int mat[][] = {{ 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 },{ 17, 18, 19, 20 }};

        System.out.print("\nDiagonal printing of matrix is \n");
        diagonalOrder(mat);
    }
}
