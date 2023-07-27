// With Number of Parameters

// public class Function_overload {

//     // fxn to calculate sum of 2 numbers
//     public static int sum (int a, int b){
//         return a + b;
//     }

//     // fxn to calc sum of 3 numbers
//     public static int sum (int a, int b, int c) {
//         return a + b + c;
//     }
//     public static void main (String args []) {
//         System.out.println(sum(3, 6));
//         System.out.println((sum(3, 5, 6)));
//     }
// }


// Using Data Types
// public class Function_overload {

//     // fxn to calculate int sum
//     public static int sum (int a, int b){
//         return a + b;
//     }

//     // fxn to calc float sum
//     public static float sum (float a, float b) {
//         return a + b;
//     }
//     public static void main (String args []) {
//         System.out.println(sum(3, 6));
//         System.out.println((sum(3.2f, 5.9f)));
//     }
// }

// Number is prime or not
// only for n>=2
// public class Function_overload {
//     public static boolean isPrime (int n) {
//         // CORNER CASES
//         // FOR NUMBER 2
//         if (n==2) {
//             return true;
//         }

//         // if we have 2, then only above fill run
//         // and below method will not run, it will direct print true after seeung 2

//         // boolean isPrime = true; OR method
    
//         for (int i = 2; i < n; i++){
//             if (n % i == 0) { // completely dividing
//                 // isPrime = false;
//                 // break;
//                 // OR OR OR 
//                 return false; // bc if n%i==0, then, ofcourse it is false
//             }
//         }
    
//         // return isPrime;
//         // OR OR OR 
//         return true;
//     }
    
//     public static void main (String args[]) {
//         System.out.println(isPrime(12));
//     }
// }



// Check PRIME (OPTIMIZED method)
// public class Function_overload {
    
//     public static boolean isPrime (int n) {
//         if (n == 2){
//             return true;
//         }
        
//         for (int i=2; i <= Math.sqrt(n); i++){
//             if (n % i ==0){
//                 return false;
//             }
//         }

//         return true;
//     }
    
//     public static void main (String args[]) {
//         System.out.println(isPrime(12));
//     }
// }


// Print all Primes in a RANGE (like print every prime from 1-10)
public class Function_overload {
    
    public static boolean isPrime (int n) {
        if (n == 2){
            return true;
        }
        
        for (int i=2; i <= Math.sqrt(n); i++){
            if (n % i ==0){
                return false;
            }
        }

        return true;
    }

    public static void primesInRange (int n){
        for (int i = 2; i <= n; i++){
            if (isPrime(i)) { //true
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    
    public static void main (String args[]) {
        primesInRange(20);  // 2 to 20
    }
}
