// public class Operator {
//     public static void main(String args[]) {
        
//         // Binary:

//         // int A = 10;
//         // int B = 5;
//         // System.out.println("Add = " + (A+B));
//         // System.out.println("Sub = " + (A-B));
//         // System.out.println("Mul = " + (A*B));
//         // System.out.println("Div = " + (A/B));
//         // System.out.println("Rem = " + (A%B));

//         // Unary:
//         // Increment:

//         // Pre-increment:
//         // int a = 10;
//         // int b = ++a;
//         // System.out.println(a);
//         // System.out.println(b);

//         // Post-increment:
//         // int a = 10;
//         // int b = a++;
//         // System.out.println(a);
//         // System.out.println(b);

//         // Decrement:
//         // Pre-Decrement:
//         // int a = 10;
//         // int b = --a;
//         // System.out.println(a);
//         // System.out.println(b);

//         // Post-Decrement:
//         int a = 10;
//         int b = a--;
//         System.out.println(a);
//         System.out.println(b);
//     }
// }


// Relational Operators:
// public class Operator{
//     public static void main(String args[]) {
//         int A = 10;
//         int B = 10;
//         System.out.println(A==B);
//         System.out.println(A!=B);

//         int c = 25;
//         int d = 18;
//         System.out.println(c > d);
//         System.out.println(c < d);

//         int f = 10;
//         int e = 10;
//         System.out.println(f>=e);
//         System.out.println(f<=e);
//     }
// }

// Logical Opeartos:
// public class Operator {
//     public static void main(String args[]) {
        
//         // Logical And
//         System.out.println( (4<6) && (6>4) );

//         // Logical OR
//         System.out.println( (2>6) || (2<1) );

//         // Logical NOT
//         System.out.println( !(5<6) );
//     }
// }

// Assignment Operator:
public class Operator {
    public static void main(String args[]) {
        
        int A = 10;
        // A = A+10;
        // A += 10;
        A -= 8;   
        System.out.println(A);

        int B = 6;
        // B = B * 2;
        // B *= 2; Faster execution format
        // B /= 2;
        B %= 2;
        System.out.println(B);
    }
}