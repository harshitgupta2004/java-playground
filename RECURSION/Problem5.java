// Print Nth FIBONACCI Number

public class Problem5 {

    public static int fibonacci(int n) {
        // Base Case
        if(n == 0 || n == 1){
            return n;
        }
        // int fnm1 = fibonacci(n-1);
        // int fnm2 = fibonacci(n-2);
        int fn = fibonacci(n-1) + fibonacci(n-2);
        return fn;
    }
    public static void main(String args[]) {
        int n = 6;
        System.out.println(fibonacci(n));
    }
}
