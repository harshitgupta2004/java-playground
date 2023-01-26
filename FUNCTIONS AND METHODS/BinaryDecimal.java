// public class BinaryDecimal {

//     public static void binToDec (int binNum) {
//         int myNum = binNum;
//         int pow = 0;
//         int decNum = 0;

//         while (binNum > 0) {
//             int lastDigit = binNum % 10;
//             decNum = decNum + (lastDigit * (int)Math.pow(2, pow)); // as pow fxn only give double, so we have to type cast it into int

//             pow++;
//             binNum = binNum/10;
//         }

//         System.out.println("Decimal of " + myNum + " = " + decNum);
//     }
//     public static void main (String args[]) {
//         binToDec(10110);
//     }
// }


// DECIMAL TO BINARY
public class BinaryDecimal {

    public static void decToBin (int n) {
        int myNum = n;
        int pow = 0;
        int binNum = 0;

        while (n > 0) {
            int rem = n % 2; // reminader
            binNum = binNum + (rem * (int)Math.pow(10, pow));
            
            pow++;
            n = n / 2; // quotient
        }

        System.out.println("Binary of " + myNum + " = " + binNum);
    }
    public static void main (String args[]) {
        decToBin(15);
    }
}
