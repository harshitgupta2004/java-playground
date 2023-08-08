// Given a square maze containing positive numbers, find all paths from a corner cell (any of the extreme four corners) to the middle cell. We can move exactly n steps from a cell in 4 directions i.e. North, East, West and South where n is value of the cell, 
// We can move to mat[i+n][j], mat[i-n][j], mat[i][j+n], and mat[i][j-n] from a cell mat[i][j] where n is value of mat[i][j]

public class ReachMiddleCell {
    public static void printPath(int maze[][], int i, int j, String ans){
        // if reach middle cell
        if(i == maze.length/2 && j == maze.length/2){
            ans += "(" + i + "," + j + ") -> MID";
            System.out.println(ans);
            return;
        }

        // If the element at the current position in maze is 0, simply Return as it has been visited before
        if(maze[i][j] == 0){
            return;
        }

        // if non zero
        int k = maze[i][j];
        // Mark the cell visited by making the element 0. Don't worry, the element is safe in 'k'
        maze[i][j] = 0;

        // all four dir
        // right
        if(j + k < maze.length){
            printPath(maze, i, j+k, ans+"("+i+","+j+") -> ");
        }

        // down 
        if(i + k < maze.length){
            printPath(maze, i+k, j, ans+"("+i+","+j+") -> ");
        }

        // left
        if(j - k > 0){
            printPath(maze, i, j-k, ans+"("+i+","+j+") -> ");
        }

        // up
        if(i - k > 0){
            printPath(maze, i-k, j, ans+"("+i+","+j+") -> ");
        }

        // Unmark the visited cell by substituting its original value from 'k'
        maze[i][j] = k;
    }
    public static void main(String[] args) {
        int[][] maze = {
            { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
            { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
            { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
            { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
            { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
            { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
            { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
            { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
            { 6, 2, 4, 3, 4, 5, 4, 5, 1 }
        };
         
        // Calling the printPath function
        printPath(maze,0,0,"");
    }
}
