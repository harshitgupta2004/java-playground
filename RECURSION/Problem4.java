// Print SUM of first n Natural numbers

public class Problem4 {
    public static int calcSum(int n) {
        //Base case
        if(n == 1) {
            return 1;
        }
        
        // int Snm1 = calcSum(n-1); //calc sum of n-1 nos
        int Sn = n + calcSum(n-1); //calc sum of n nos
        return Sn;
    }

    public static void main(String args[]) {
        int n = 5;
        System.out.println(calcSum(n));
    }
}
 