public class BitWiseOP{

    // Check Even Or Odd
    public static void EvenorOdd(int n) {
        int bitMask = 1; //that number with which we are going to perform our operation with n
        if((n & bitMask) == 0){
            System.out.println("Number is Even");
        } else{
            System.out.println("Number is Odd");
        }
    }


    // Get ith Bit:
    public static int getIthBit(int n, int i){
        int bitMask = 1<<i;
        if((n & bitMask) == 0){
            return 0;
        } else {
            return 1;
        }
    }

    // Set ith Bit:
    public static int setIthBit(int n, int i) {
        int bitMask = 1<<i;
        return n | bitMask;
    }

    // Clear ith Bit:
    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    // Update ith Bit:
    public static int updateIthBit(int n, int i, int newBit) { //newBit is update value either change to 0 or 1
        // if(newBit == 0){
        //     return clearIthBit(n, i);
        // } else{
        //     return setIthBit(n, i);
        // }

        // 2nd Approach : in which we firstly clear the ith bit
        n = clearIthBit(n, i);
        int bitMask = newBit<<i; //if nb = 0, then the result will always be 0; but if nb = 1, then result is ith bit set
        return n | bitMask;
    }

    // Clear Last i Bits:
    public static int clearIBits(int n, int i) {
        int bitMask = ((-1) << i); // or (~0<<i)
        return n & bitMask;
    }

    // Clear Range of Bits
    public static int clearRange(int n, int i, int j) {
        int a = (~0 << (j+1));
        int b = (1 << i) - 1;
        int bitMask = a|b;
        return n & bitMask;
    }


    // Check If a Numbers is a POWER of 2 or not:
    public static boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0; //if value is 0, return true; otherwise false
    }


    // Count SET Bits in a Number
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0){
            if((n & 1) != 0){ //comparing LSB everytime //check our LSB
                count++; 
            }
            n = n>>1; //everytime we R.shift n by 1
        }
        return count;
    }



    // FAST EXPONENTIATION
    public static int fastExpo(int a, int n) { //a^n calculate
        int ans = 1;

        while(n > 0){
            if((n & 1) != 0){ //Check LSB - Analysing the bits // here, if LSb is giving non zero value means LSB is our set bit, LSB is 1
                ans = ans * a; // So, we have to multiple the ans by power
            } //and after each step
            a = a * a;
            n = n>>1; //we R.shift each bit by one
        }

        return ans;
    }


    // MODULAR EXPONENTIATION:
    public static int ModularExpo(int a, int n, int x) {
        int ans = 1;

        while(n>0){
            //If n is odd, multiple a with ans
            if((n & 1) != 0){
                ans = ans * a;
            }
            // n must be even now
            n = n>>1; //n = n/2
            a = a*a; //change a to a^2
        }

        return ans % x;

        // Efficient Approach
        int ans = 1;

        a = a % x; //update a if it is more than or equal to x
        if(a == 0){
            return 0; //in case a is divisible by x
        }

        while(n>0){
            //If n is odd, multiple a with ans
            if((n & 1) != 0){
                ans = (ans * a) % x;
            }
            // n must be even now
            n = n>>1; //n = n/2
            a = (a*a) % x;
        }

        return ans;
    }
    public static void main(String args[]) {
        // BINARY AND &
        System.out.println((5 & 6));

        // BINARY OR |
        System.out.println((5 | 6));

        // BONARY XOR ^
        System.out.println((5 ^ 6));

        // BINARY ONE'S COMPLEMENT
        System.out.println((~ 5));

        // BINARY LEFT SHIFT <<
        System.out.println((5 << 2));

        // BINARY RIGHT SHIFT >>
        System.out.println((6 >> 1));

        // Number is Even or Odd
        EvenorOdd(9);
        EvenorOdd(4);
        EvenorOdd(14);

        // Get ith bit
        System.out.println(getIthBit(15, 2));

        // Set ith bit
        System.out.println(setIthBit(10, 2));

        // Clear ith bit
        System.out.println(clearIthBit(10, 1));

        // Update ith bit
        System.out.println(updateIthBit(10, 2, 1));

        // Clear Last i bits
        System.out.println(clearIBits(15, 2));

        // Clear Range of bits
        System.out.println(clearRange(10, 2, 4));

        // POWER of 2 or not
        System.out.println(isPowerOfTwo(15));

        // Count SET Bits in number
        System.out.println(countSetBits(15));

        // Fast Exponentiation
        System.out.println(fastExpo(3, 5));

        // Modular Exponentiation
        System.out.println(ModularExpo(2, 3, 5));
    }
}