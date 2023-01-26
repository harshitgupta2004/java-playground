import java.util.Scanner;

// public class Functions {
//     public static void printHelloWorld() {
//         System.out.println("Hello World");
//         System.out.println("Hello World");
//         return; 
//         // return 3 ; it will used when we have int return type
//         // otherwise, dont' use return in void
//         // only use when return type is not void
//     }

//     public static void main (String args []) {
//         printHelloWorld();; // calls a function (fxn call)
//     }
// }

// Syntax with PARAMETERS
public class Functions {
    public static void printHelloWorld() {
        System.out.println("Hello World");
        System.out.println("Hello World");
        return; 
    }

    public static void calculateSum(int num1, int num2) { // PARAMETERS OR FORMAL PARAMETERS
        int sum = num1 + num2;
        System.out.println("Sum is: " + sum);
    }

    public static void main (String args []) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        calculateSum(a, b); // ARGUMENTS OR ACTUAL PARAMETERS
    }
}