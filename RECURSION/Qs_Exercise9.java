// 1. Find all the occurrences(indices) of a given element(Key) and print them.

// public class Qs_Exercise9 {

//     public static void allOccurences(int arr[], int key, int i) {
//         // base case
//         if (i == arr.length) {
//             return;
//         }

//         if (arr[i] == key) {
//             System.out.print(i+" ");
//         }
//         allOccurences(arr, key, i+1);
//     }
//     public static void main(String args[]) {
//         int arr[] = {3,2,4,5,6,2,7,2,2};
//         int key = 2;
//         allOccurences(arr, key, 0);
//         System.out.println();

//     }
// }


// 2. You are given a number(Eg-2019), convert it into a String of english like "two zero one nine".
// Note: The digits of no will only be in range 0-9 and the last digit of a no can't be 0
// public class Qs_Exercise9 {

//     static String digits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

//     public static void printDigits(int number) {
//         if(number == 0) {
//             return;
//         }

//         int lastDigit = number % 10;
//         printDigits(number/10);
//         System.out.print(digits[lastDigit]+" ");
//     }
//     public static void main(String args[]) {
//         printDigits(1947);
//     }
// }



// 3. Find Length of a String using Recursion
// public class Qs_Exercise9 {

//     public static int lenString(String str) {
//         if(str.length() == 0) {
//             return 0;
//         }

//         return lenString(str.substring(1)) + 1;
//     }
//     public static void main(String args[]) {
//         String str = "Harshit";
//         System.out.println(lenString(str));
//     }
// }



// 4. We are given a string S,we need to find the count of all contiguous substrings starting and ending with the same character
public class Qs_Exercise9 {

    public static int countSubStrs(String str, int i, int j, int n) {
        if(n == 1) {
            return 1;
        }
        if(n <= 0) {
            return 0;
        }

        int res = countSubStrs(str, i+1, j, n-1) +
                  countSubStrs(str, i, j-1, n-1) -
                  countSubStrs(str, i+1, j-1, n-2);
        
        if(str.charAt(i) == str.charAt(j)) {
            res++;
        }
        return res;
    }
    public static void main(String args[]) {
        String str = "abcab";
        int n = str.length();
        System.out.println(countSubStrs(str, 0, n-1, n));
    }
}