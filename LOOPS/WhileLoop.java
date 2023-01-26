import java.util.Scanner;

// While Loop:
// public class WhileLoop {
//     public static void main(String args[]) {
//         int counter = 0;

//         while (counter < 10) {
//             System.out.println("hello harshit");
//             counter++;
//         }

//         System.out.println("Printed HH 10x");
//     }
// }

// Infinite loops
// public class WhileLoop {
//     public static void main(String args[]) {
//         int counter = 0;

//         while (true) { // this true gives infinite loop
//             System.out.println("hello harshit");
//             counter++;
//         }
//     }
// }

// Priting nos from 1 to 10
// public class WhileLoop {
//     public static void main(String args[]) {
//         int numbers = 1;

//         while (numbers <= 10) {
//             System.out.print(numbers);
//             numbers++;
//         }
//     }
// }

// Print nos from 1 to n
// public class WhileLoop {
//     public static void main(String args[]) {
//         Scanner sc = new Scanner (System.in);
//         int range = sc.nextInt();
//         int numbers = 1;

//         while (numbers <= range) {
//             System.out.print(numbers + " ");
//             numbers++;
//         }
//     }
// }

// Print Sum of first n natural nos
public class WhileLoop {
    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int sum = 0;
        int i = 1; // i is called iterator and is used to iterate (means loop lagana)

        while (i <= n) {
            sum += i;
            i++;
        }

        System.out.println("Sum is : " + sum);
    }
}