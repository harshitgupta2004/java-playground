// Number of Parenthesis Combinations
// Given N number of parenthesis (pair of opening and closing parenthesis), you have to count all the valid combinations of the parenthesis

public class Qs_Exercise_21_5 {
    public static int helper(int left, int right) {
        int ans = 0;
        if(left == 0 && right == 0){
            ans++;
        }
        if (left > right){
            return 0;
        }
        if (left > 0){
            helper(left-1, right);
        }
        if (right > 0){
            helper(left, right-1);
        }
        return ans;
    }

    private static int countWays(int n) {
        if((n & 1) != 0){
            return 0;
        }
        return helper(n/2, n/2);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countWays(n));
    }
}
