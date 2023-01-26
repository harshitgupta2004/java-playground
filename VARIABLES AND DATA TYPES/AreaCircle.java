import java.util.Scanner;

public class AreaCircle {
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        float radius = sc.nextFloat();
        float Area_of_Circle = 3.14f * radius * radius;
        System.out.println(Area_of_Circle);
    }
}
