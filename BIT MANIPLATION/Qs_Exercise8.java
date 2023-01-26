public class Qs_Exercise8 {

    // SWAP Two nos without using any third variable
    //The idea is to use XOR operators to swap two numbers by their property x ^ x = 0
    // public static void main(String args[]) {
    //     int x = 3, y = 4;
        
    //     //swap using XOR
    //     x = x ^ y;
    //     y = x ^ y;
    //     x = x ^ y;
    //     System.out.println("After Swap: x = " + x + " and y ="+ y);
    // }


    // Add 1 to an integer using bit manipulation
    // Using Bitwise NOT operator
    // -x = ~x + 1;
    // -~x = x + 1 (by replacing x by ~x)
    // public static void main(String args[]) {
    //    int x = 6;
    //    System.out.println(x + " + " + 1 + " is " + -~x);
       
    //    x = -4;
    //    System.out.println(x + " + " + 1 + " is " + -~x);

    //    x = 0;
    //    System.out.println(x + " + " + 1 + " is " + -~x);
    // }


    // Convert Uppercase characters to Lowercase using bits
    // Here, a trick is used
    public static void main(String args[]) {
        //Convert uppercase charcter to lowercase
        for(char ch = 'A'; ch <= 'Z'; ch++){
            System.out.print((char) (ch | ' '));
            //prints abcdef......xyz
        }
    }
}
