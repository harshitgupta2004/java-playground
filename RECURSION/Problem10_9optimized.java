// Print x^n in TC = O(log n)

public class Problem10_9optimized {
    public static int optimizedPower(int a, int n) {
        // base case
        if(n == 0) {
            return 1;
        }

        int halfPower = optimizedPower(a, n/2); // this var calls the fxn at its inner level
        int halfPowerSq = halfPower * halfPower;
        
        //int halfPowerSq = optimizedPower(a, n/2) * optimizedPower(a, n/2); //divide our power by half and call for upper level
        // if n is even, then no problem, just need to return above thing
        
        //In 11th line, we have to call optimizedpower fxn 2 times to do the same thing, so the computation time will become more, so, we do the above method, to reduce time complexity by calling the fxn only single time

        //n is odd
        if(n % 2 != 0) {
            halfPowerSq = a * halfPowerSq;
        }

        return halfPowerSq;
    }

    public static void main(String args[]) {
        int a = 2;
        int n = 10;
        System.out.println(optimizedPower(a, n));
    }
}
