import java.util.Scanner;

// public class doWhile {
//     public static void main (String args[]) {
//         int counter = 1;
//         do {
//             System.out.println("Hello harshit");
//             counter++;
//         } while (counter <= 10);
//     }
// }

// Break Statement:
// public class doWhile {
//     public static void main (String args[]) {
//         for (int i = 1; i <= 5; i++) {
//             if (i == 3) {
//                 break; // loop breaks when 3 came
//             }
//             System.out.println(i);
//         }

//         System.out.println("I am out of the loop");
//     }
// }

// Keep entering nos till user enters a multiple of 10
// public class doWhile {
//     public static void main (String args[]) {
//         Scanner sc = new Scanner (System.in);
        
//         do {
//             System.out.print("enter your number : ");
//             int n = sc.nextInt();
//             if (n % 10 == 0) {
//                 break;
//             }
//             System.out.println(n);
//         } while (true);
//     }
// }

// Continue Statement:
// public class doWhile {
//     public static void main (String args[]) {
//         for ( int i = 1; i <= 5; i++){
//             if (i == 2) {
//                 continue; // 2 value skips
//             }
//             System.out.println(i);
//         }
//     }
// }

// Display all nos entered by user except multiple of 10
public class doWhile {
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        for (; ;){
            System.out.print("Enter you number : ");
            int i = sc.nextInt();
            if (i % 10 == 0 ) {
                continue;
            }

            System.out.println("NUmber was : " + i);
        }
    }
}


