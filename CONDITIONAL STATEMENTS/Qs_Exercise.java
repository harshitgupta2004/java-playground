// Whether number is positive or negative
import java.util.Scanner;

// public class Qs_Exercise {
//     public static void main (String args[]) {
//         Scanner sc = new Scanner (System.in);
//         int number = sc.nextInt();

//         if (number > 0) {
//             System.out.println("Positive");
//         }
//         else {
//             System.out.println("Negative");
//         }
//     }
// }

// Temperature
// public class Qs_Exercise {
//     public static void main (String args[]) {
//         Scanner sc = new Scanner (System.in);
//         double temp = sc.nextDouble();

//         if (temp > 100) {
//             System.out.println("You have fever");
//         }
//         else {
//             System.out.println("You don't have a fever");
//         }
//     }
// }

// Java program to input week number (1-7)
// and print day of week name using switch case
// public class Qs_Exercise {
//     public static void main(String args[]) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter Week Number(1-7) : ");
//         int week_number = sc.nextInt();

//         switch(week_number) {
//             case 1: System.out.println("Monday");
//                         break;
//             case 2: System.out.println("Tuesday");
//                         break;
//             case 3: System.out.println("Wednesday");
//                         break;
//             case 4: System.out.println("Thursday");
//                         break;
//             case 5: System.out.println("Friday");
//                         break;
//             case 6: System.out.println("Saturday");
//                         break;
//             default: System.out.println("Sunday");
//         }
//     }
// }

// Leap year or not
// public class Qs_Exercise {
//     public static void main(String args[]) {
//         Scanner sc = new Scanner (System.in);
//         System.out.println("Enter a year: ");
//         int year = sc.nextInt();

//         if ( (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            
//             System.out.println("It is a leap year");
//         }
//         else {
//             System.out.println("Its' not a leap year");
//         }
//     }
// }

// Second method:
public class Qs_Exercise {

    public static void main(String[] args) {
        // The desired year to check.
        int year = 1998;
        
        // Implementing our algorithm.
        if (year % 400 == 0) {
            System.out.println(year + " is a leap year.");
        } else if (year % 100 == 0) {
            System.out.println(year + " is not a leap year.");
        } else if (year % 4 == 0) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
        
    }
}

