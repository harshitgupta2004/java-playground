import java.util.Scanner;

public class Strings {

    // Print all letters of a string
    public static void printLetters(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
    }

    public static void main(String args[]) {
        char arr[] = { 'a', 'b', 'c', 'd' }; // character array

        String str = "abcd"; // memory me value store hui abcd, jo ki string type ki hai
        String str2 = new String("xyz"); // woth new keyword
        // both above are the methods to declare a string

        // Strings in JAVA are IMMUTABLE
        // means strings cannot be change in java, we cannot make any changes in the
        // already created strings

        // INPUT/OUTPUT
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        // String name;
        // name = sc.next();
        System.out.println("Name is: " + name);

        // String LENGTH
        String fullname = "Harshit Gupta"; // space only het counted in length
        System.out.println(fullname.length());

        // String CONCATENATION
        String firstname = "Harshit";
        String lastname = "Gupta";
        String fullname2 = firstname + " " + lastname; // combing one string to the end of another string
        System.out.println(fullname2);
        // OR USE concat() method - but not use it as using + is more easy
        String s = "hello ";
        s = s.concat("World");
        System.out.println(s);

        // TO find a Character in a String using CharAt
        System.out.println(fullname2.charAt(9));

        printLetters(fullname2);

        // String FUNCIONS - COMPARE
        // Using EQUALS FUNCTION
        String s1 = "Joy";
        String s2 = "Joy";
        String s3 = new String("Joy");

        // if(s1 == s2){
        // System.out.println("Stings are equal");
        // } else{
        // System.out.println("Strings are not equal");
        // }

        // if(s1 == s3){
        // System.out.println("Stings are equal");
        // } else{
        // System.out.println("Strings are not equal");
        // }

        if (s1.equals(s3)) { // equals function is used to compare Strings
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }

    }
}