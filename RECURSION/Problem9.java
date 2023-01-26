// Print x^n (power)

public class Problem9 {

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int xnm1 = power(x, n-1);
        int xn = x * xnm1;
        return xn;
        // or we can alos write above 3 lines in 1 line
        // return x * power(x, n-1);
    }
    public static void main(String args[]) {
        System.out.println(power(2, 10));
    }
}
