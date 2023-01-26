// STAR PATTERN
// public class Patterns {
//     public static void main(String args[]) {
//         for (int line = 1; line <= 5; line++){
//             // one line
//             for (int star = 1; star <= line; star++){
//                 System.out.print("*");
//             }
//             System.out.println();
//         }
//     }
// }


// INVERTED STAR PATTERN
// public class Patterns {
//     public static void main(String args[]) {
//         int n =7; //total no of lines
//         for (int line = 1; line <= n; line++){
//             // one line
//             for (int star = 1; star <= n-line+1; star++){
//                 System.out.print("*");
//             }
//             System.out.println();
//         }
//     }
// }


// HALF PYRAMID PATTERN
// public class Patterns {
//     public static void main(String args[]) {
//         int n = 4;
//         for (int line = 1; line <= n; line++){
//             // numbers print
//             for (int number = 1; number <= line; number++){
//                 System.out.print(number);
//             }
//             System.out.println();
//         }
//     }
// }


// Print CHARACTER Pattern
public class Patterns {
    public static void main(String args[]) {
        int n = 5;
        char ch = 'A';
        
        // outer loop
        for (int line = 1; line <= n; line++){
            // inner loop
            for (int chars = 1; chars <= line; chars++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
}

