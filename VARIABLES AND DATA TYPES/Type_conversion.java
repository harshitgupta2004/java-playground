import java.util.Scanner;

public class Type_conversion {
    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);
        float number = sc.nextInt(); // int converts into float 10.0, implicit/widening conversion
        System.out.println(number);
    }
}
