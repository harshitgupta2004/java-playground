public class callByValue {

    public static void swap(int a, int b) {
        // swap
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void main (String args[]) {
        // Swap - values exchange
        int a = 5;
        int b = 10;
        swap(a,b);
        
    }
}

// jb bhi hum koi values paas krte hain fxn me to to uski original nhi but orginal ki copy paas hoti hai