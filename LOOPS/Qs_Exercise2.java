import java.util.Scanner;

// reads a set of integers, and then prints the sum of the even and odd integers.
// public class Qs_Exercise2 {
//     public static void main (String args[]) {
//         Scanner sc = new Scanner(System.in);

//         int number;
//         int choice;
//         int evenSum = 0;
//         int oddSum = 0;

//         do {
//             System.out.println("Enter your number");
//             number = sc.nextInt();

//             if (number % 2 == 0){
//                 evenSum += number;
//                 // System.out.println("Sum even : " + evenSum);
//             } else {
//                 oddSum += number;
//                 // System.out.println("Odd Sum : " + oddSum);
//             }

//             System.out.println("Do you want to continue? Press 1 for yes or 0 for no");
//             choice = sc.nextInt();
//         } while (choice == 1);

//         System.out.println("Sum of even nos: " + evenSum);
//         System.out.println("Sum of odd nos:" + oddSum);
//     }
// }

// find the factorial of any number entered by the user

// public class Qs_Exercise2 {
//     public static void main (String args[]) {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter any positive number");
//         int number = sc.nextInt(); // To hold number

//         int factorial = 1; // To hold factorial

//         for (int i = 1; i <= number; i++) {
//             factorial *= i;
//         }

//         System.out.println("Factorial : " + factorial);
//     }
// }

// print the multiplication table of a number N, entered by the user
public class Qs_Exercise2 {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();

        for (int i = 1; i <= 10; i++){
            System.out.println(n + " * " + i + " = " + (n*i));
        }
    }
}