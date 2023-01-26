import java.util.Scanner;

public class JavaMath {
    public static void main (String args[]) {
        System.out.println("Enter 1st number:");
        Scanner sc = new Scanner(System.in);
        double num1 = sc.nextDouble();
        System.out.println("Enter 2nd number:");
        double num2 = sc.nextDouble();

        // max of 2 numbers
        System.out.println("Max of 2 nos is: " +  Math.max(num1, num2));

        // min of 2 numbers
        System.out.println("Min of 2 nos is: " +  Math.min(num1, num2));

        // square root of num2
        System.out.println("Square Root of num2 is: " +  Math.sqrt(num2));

        // power of num1 to num2
        System.out.println("Power of num1 and num2 is: " +  Math.pow(num1, num2));

        // absolute value of no
        System.out.println("Absolute value of 2 nos is: " +  Math.abs(num1));
    }
}
