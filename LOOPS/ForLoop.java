// public class ForLoop {
//     public static void main(String args[]) {
        
//         for (int i=1 ; i <= 10; i++) {
//             System.out.println("Hello harshit");
//         }
//     }
// }


// Print SQUARE Pattern
// public class ForLoop {
//     public static void main(String args[]) {
        
        // for (int line = 1 ; line <= 4; line++) {
        //     System.out.println("****");
        // }

        // by while loop
//         int line = 1;
//         while (line <=4) {
//             System.out.println("****");
//             line++;
//         }
//     }
// }


// Print REVERSRE of a number
// n = 10899
// last digit = n % 10 (remainder = last digit)
// 1. agr last digit chahiye kisi no ka to num%10
// kisi bhi no ke last digit ko remove krne ke tareeka hota hai usko 10 se divide krdo
// remove last digit - num/10
// public class ForLoop {
//     public static void main(String args[]) {
        
        // for (int n = 10899 ; n > 0; n/=10) {
        //     int lastDigit = n % 10;
        //     System.out.print(lastDigit + " ");
        // }

        // while loop
//         int n = 10899;
//         while (n > 0){
//             int lastDigit = n % 10;
//             System.out.print(lastDigit + " ");
//             n = n / 10;
//         }
//     }
// }


// REVRSE the number
// reverse = (reverse * 10) + last digit
public class ForLoop {
    public static void main(String args[]) {
        
        // for (int n = 10899 ; n > 0; n/=10) {
        //     int lastDigit = n % 10;
        //     int rev = 0;
        //     rev = (rev * 10) + lastDigit;
        //     System.out.print(rev);
        // }

        // while loop
        int n = 10899;
        int rev = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            rev = (rev * 10) + lastDigit;
            n /= 10;
        }

        System.out.println(rev);
    }
}


