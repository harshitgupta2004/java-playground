public class Problem1_2 {

    // PRINT NOS FROM n to 1 (Decreasing Order)
    public static void printDec(int n) {
        if(n == 1) { //base case
            System.out.println(n);
            return;
        }
        System.out.print(n + " "); //prints n value
        printDec(n-1); // call its inner fxn for n-1 
    }


    // PRINT NOS FROM 1 to n (Increasing Order)
    public static void printInc(int n) {
        if(n == 1) {
            System.out.print(n+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }


    public static void main(String args[]) {
        int n = 10;
        printDec(n);
        printInc(n);
    }
}