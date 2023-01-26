import java.util.Scanner;

// public class Qs_Exercise3 {
//     public static boolean isEven (int number) {
//         if (number % 2 == 0){
//             return true;
//         } else {
//             return false;
//         }
//     }

//     public static void main (String args[]) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter an integer: ");
//         int num = sc.nextInt();

//         if (isEven(num)) {
//             System.out.println("Even");
//         } else {
//             System.out.println("Odd");
//         }
//         // System.out.println(isEven(number));

//     }
// }


// PALINDROME 
// public class Qs_Exercise3 {
//     public static boolean isPalindrome (int number) {
//         int palindrome = number; // copied number into variable
//         int reverse = 0;
        
//         while (palindrome != 0) {
//             int remainder = palindrome % 10;
//             reverse = reverse * 10 + remainder;
//             palindrome = palindrome/10;
//         }
        
//         // if origial and the reverse of number is qeual number is palindrome in java
//         if (number == reverse){
//             return true;
//         } else {
//             return false;
//         }
//     }

//     public static void main (String args[]) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter a number: ");
//         int palindrome = sc.nextInt();

//         if (isPalindrome(palindrome)) {
//             System.out.println("Number: " + palindrome + " is palindrome");
//         } else {
//             System.out.println("Number: " + palindrome + " is not palindrome");
//         }

//     }
// }



// Compute the sum of the digits in an integer
public class Qs_Exercise3 {
    public static int sumDigits (int number) {
        int sumOfDigits = 0;
                
        while (number > 0) {
            int lastDigit = number % 10;
            sumOfDigits = sumOfDigits + lastDigit;
            number /= 10;
        }

        return sumOfDigits;
    }

    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input an Integer: ");
        int number = sc.nextInt();
        System.out.println("The sum is " + sumDigits(number));

    }
}