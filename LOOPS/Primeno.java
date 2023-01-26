import java.util.Scanner;

public class Primeno {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter Your Number : ");
        int number = sc.nextInt();
        
        if (number == 2){
            System.out.println("Its a prime number");
        }
        else {
            boolean isPrime = true; // firstly, we assume that our no is prime
            // for (int i = 2; i <= number-1; i++) // below is more optimized as i to underroot n, because all factors(multiples) repeat itlself at half, so to avoid that
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if(number % i == 0){ // number is a multiple of i (i not equal to 1 or n)
                    isPrime = false;
                }
            }

            if (isPrime == true) {
                System.out.println("Its a Prime Number");
            } else {
                System.out.println("Not a prime number");
            }
        }
    }    
}
