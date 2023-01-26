import java.util.LinkedList;
import java.util.Queue;

// Minimum time required to rot all oranges
// We have a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
// 0: Empty cell 1: Cells have fresh oranges 2: Cells have rotten oranges
// We have to determine what is the minimum time required so that all the oranges become rotten. 
// A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). 
// If it is impossible to rot every orange then simply return -1.

// TC = SC = O(r*c)

public class Qs_Exerices20_3 {
    public final static int R = 3;
    public final static int C = 5;

    static class Ele {
        int x = 0;
        int y = 0;
        Ele(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static boolean isValid(int i, int j){
        return (i >= 0 && j >= 0 && i < R && j < C);
    }

    static boolean isDelim(Ele temp) {
        return (temp.x == -1 && temp.y == -1);
    }

    static boolean checkAll(int arr[][]){
        for(int i = 0; i < R; i++){
            for(int j = 0; i < C; j++){
                if(arr[i][j] == 1){
                    return true;
                }
            }
        }
        return false;
    }

    static int Solution(int arr[][]) {
        Queue<Ele> Q = new LinkedList<>();
        Ele temp;
        int ans = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(arr[i][j] == 2) {
                    Q.add(new Ele(i, j));
                }
            }
        }

        Q.add(new Ele(-1, -1));

        while(! Q.isEmpty()){
            boolean flag = false;
            while(!isDelim(Q.peek())){
                temp = Q.peek();
                if(isValid(temp.x+1, temp.y) && arr[temp.x+1][temp.y] == 1) {
                    if(!flag){
                        ans++;
                        flag = true;
                    }
                    arr[temp.x+1][temp.y] = 2;

                    temp.x++;
                    Q.add(new Ele(temp.x, temp.y));
                    temp.x--;
                }

                if(isValid(temp.x-1, temp.y) && arr[temp.x-1][temp.y] == 1){
                    if(!flag){
                        ans++;
                        flag = true;
                    }
                    arr[temp.x-1][temp.y] = 2;
                    temp.x--;

                    Q.add(new Ele(temp.x, temp.y)); // push this cell to queue
                    temp.x++;
                }

                if(isValid(temp.x, temp.y+1) && arr[temp.x][temp.y+1] == 1){
                    if(!flag){
                        ans++;
                        flag = true;
                    }
                    arr[temp.x][temp.y+1] = 2;
                    temp.y++;
                    
                    Q.add(new Ele(temp.x,temp.y)); // push this cell to queue
                    temp.y--;
                }

                if (isValid(temp.x, temp.y-1) && arr[temp.x][temp.y-1] == 1){
                    if (!flag){
                        ans++;
                        flag = true;
                    }
                    arr[temp.x][temp.y-1] = 2;
                    temp.y--;

                    Q.add(new Ele(temp.x, temp.y)); // push this cell to queue
                }
                Q.remove();
            }
            Q.remove();if(!Q.isEmpty()){
                Q.add(new Ele(-1, -1));
            }
        }
        return (checkAll(arr))? -1:ans;
    }

    public static void main(String[] args) {
        int arr[][] = {{2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
        int ans = Solution(arr);

        if(ans == -1){
            System.out.println("All oranges cannot rot");
        }
        else {
            System.out.println("Time required for all orange to rot = " + ans);
        }
    }
}
