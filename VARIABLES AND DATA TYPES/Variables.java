// public class Variables {
//     public static void main(String args[]) {
//         int a = 10;
//         int b = 5;
//         System.out.println(a); 
//         System.out.println(b);     
        
//         String name = "Harshit";
//         String Last_name = "Gupta";
//         System.out.println(name);
//         System.out.println(Last_name);

//         b = a;
//         System.out.println(b);

//         Last_name = "Mahajan";
//         System.out.println(Last_name);
//     }
// }

// Data Types:
// public class Variables {
//     public static void main(String args[]) {
//         byte a = 8;
//         System.out.println(a);

//         char character = 'a';
//         System.out.println(character);

//         boolean var = false;
//         float price = 2.57;
//         int number = 67;
//         // long
//         // double
//         short n = 255;
//     }
// }

// Sum of 2 nos:
// public class Variables{
//     public static void main(String args[]) {
//         int a = 15;
//         int b = 8;
//         int sum = a+b;
//         System.out.println(sum);
//     }
// }

// Single line comment

/* Now this is a
 * multi line comment
 * we can use it by using this method
 */

// Sum of two nos by user i/p:
import java.util.*;
public class Variables {
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = a + b;
        System.out.println(sum);
    }
} 