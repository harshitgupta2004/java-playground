// import java.util.Scanner;

// public class Condition_statements {
//     public static void main(String args[]) {
//         Scanner sc = new Scanner (System.in);
//         int age = sc.nextInt();
        
//         if (age >= 18) {
//             System.out.println("Adult: drive, vote");
//         }

//         else if (age >= 13 && age < 18) {
//             System.err.println("Teenager");
//         }

//         else {
//             System.out.println("Not Adult");
//         }
//     }
// }


// Print the largest od 2 :
// public class Condition_statements {
//     public static void main(String args[]) {
//         int A = 1;
//         int B = 4;

//         if (A>=B) {
//             System.out.println("A is largest of 2");
//         }
//         else {
//             System.out.println("B is largest of 2");
//         }
//     }
// }

// Print if no is odd or even
// public class Condition_statements {
//     public static void main(String args[]) {
//         int n = 17882912;

//         if ( n % 2 == 0) {
//             System.out.println("Even");
//         }
//         else {
//             System.out.println("Odd");
//         }
//     }
// }

// Print the largest of 3:
public class Condition_statements {
    public static void main(String args[]) {
        int A = 5;
        int B = 9;
        int C = 6;
    
        if ( (A >= B) && (A >= C)) {
            System.out.println("A is largest of 3");
        }
        else if (B >= C) {
            System.out.println("B is largest of 3");
        }
        else {
            System.out.println("C is largest of 3");
        }
    }
}