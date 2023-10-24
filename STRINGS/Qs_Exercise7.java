import java.util.Arrays;
import java.util.Scanner;

// STRINGS
public class Qs_Exercise7 {
    public static void main(String args[]) {
        // Count how many times lowercase vowels occurred in a String entered by the
        // user
        // Scanner sc = new Scanner(System.in);
        // String lowercase = sc.nextLine();
        // OR USE BELOW
        String lowercase = new Scanner(System.in).nextLine();
        int count = 0;

        for (int i = 0; i < lowercase.length(); i++) {
            char ch = lowercase.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        System.out.println("Count of Vowels is: " + count);

        // Determine if two strings are ANAGRAMS of each other
        // ANAGRAMS - If two strings contain the same characters but in a different
        // order
        String str1 = "earth";
        String str2 = "heart";

        // Convert Strings to lowercase. Why? so that we don't have to checkseparately
        // for lower & uppercase
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // First check - if the lenghts are the same
        if (str1.length() == str2.length()) {
            // convert strings to char array
            char[] str1charArray = str1.toCharArray();
            char[] str2charArray = str2.toCharArray();

            // sort the char array
            Arrays.sort(str1charArray);
            Arrays.sort(str2charArray);

            // if the sorted char arrays are same or identical then the strings are anagram
            boolean Result = Arrays.equals(str1charArray, str2charArray);
            if (Result) {
                System.out.println(str1 + " and " + str2 + " are anagram");
            } else {
                System.out.println(str1 + " and " + str2 + " are not anagram");
            }
        } else {
            // when strings lengths not equal
            System.out.println(str1 + " and " + str2 + " are not anagrams");
        }

    }
}
