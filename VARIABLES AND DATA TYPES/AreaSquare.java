// import java.util.Scanner;

// public class AreaSquare {
//     public static void main(String args[]) {
//         Scanner sc = new Scanner (System.in);
//         int side = sc.nextInt();
//         int area = side * side;
//         System.out.println("Area of the square is : " + area + " metres square");
//     }
// }

// Total cost qs:
import java.util.*;
public class AreaSquare {
    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);
        float pencil = sc.nextFloat();
        float pen = sc.nextFloat();
        float eraser = sc.nextFloat();

        float TotalCost = pencil+pen+eraser;
        System.out.println(TotalCost);

        // Add on with 18% tax:
        float newTotal = TotalCost + (0.18f * TotalCost);
        System.out.println("Bill with tax is : " + newTotal);
    }
}