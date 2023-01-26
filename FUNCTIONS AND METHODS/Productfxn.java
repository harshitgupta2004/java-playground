// public class Productfxn {

//     public static int multiply (int a, int b){
//         int product = a * b;
//         return product;
//     }
//     public static void main (String args[]) {
//         int a = 3;
//         int b = 5;
//         int prod = multiply(a, b); 
//         System.out.println(prod);

//         int newp = multiply(10, 20);
//         System.out.println(newp);
//     }
// }


// FACTORIAL of a number, n
// public class Productfxn {

//     public static int factorial (int n){
//         int f = 1;

//         for (int i = 1; i <=n; i++) {
//             f = f * i;
//         }
//         return f;
//     }
//     public static void main (String args[]) {
//         // int n = 4;
//         // int fact = factorial(n);
//         // System.out.println(fact);

//                 // OR OR OR 

//         System.out.println(factorial(4));
//     }
// }


// BINOMIAL COFFICIENT
public class Productfxn {

    public static int factorial (int n) {
        int f = 1;

        for (int i = 1; i <=n; i++) {
            f = f * i;
        }
        return f; // factorial of n
    }

    public static int binCoeff (int n, int r) {
        int fact_n = factorial(n); // helper fxn(s)
        int fact_r = factorial(r);
        int fact_nmr = factorial(n-r);

        int binCoeff = fact_n / (fact_r * fact_nmr);
        return binCoeff; // we can also call one fxn from another fxn (not only from main fxn)
    }
    public static void main (String args[]) {
        System.out.println(binCoeff(5, 2));
    }
}
