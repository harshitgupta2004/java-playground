import java.util.*;

public class FloodFillAlgo {

    // O(m*n)
    public static void helper(int image[][], int sr, int sc, int color, boolean vis[][], int orgColor) {

        // base case
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgColor) {
            return;
        }

        image[sr][sc] = color;
        
        // left
        helper(image, sr, sc-1, color, vis, orgColor);

        //right
        helper(image, sr, sc+1, color, vis, orgColor);

        // up
        helper(image, sr-1, sc, color, vis, orgColor);

        // down
        helper(image, sr+1, sc, color, vis, orgColor);
    }

    public static int[][] floodFill(int image[][], int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length]; // m*n
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    public static void printImage(int image[][]) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int image[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;

        floodFill(image, sr, sc, color);
        printImage(image);
    }
}
