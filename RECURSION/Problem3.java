// Print FACTORIAL of a number n

public class Problem3 {

    public static int fact(int n) {
        //Base case
        if(n == 0) {
            return 1; //0! = 1
        }
        // int fnm1 = fact(n-1); // calculating n-1 factorial
        int fn = n * fact(n-1); //calc n factorial
        return fn;
    }
    public static void main(String args[]) {
        int n = 10;
        System.out.println(fact(n));
    }
}
