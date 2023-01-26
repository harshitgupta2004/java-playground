public class Problem11_Tiling {

    public static int tilingProblem(int n) { // floor size -> 2 x n, n is lenght of floor
        // base case
        if(n == 0 || n == 1) {
            return 1;
        }

        // kaam -> to take a choice
        // vertical choice
        int fnm1 = tilingProblem(n-1);

        //Horizontal choice
        int fnm2 = tilingProblem(n-2);

        int totWays = fnm1 + fnm2;
        return totWays;
    }
    public static void main(String args[]) {
        System.out.println(tilingProblem(3));
    }
}
