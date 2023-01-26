// FRIENDS PAIRING PROBLEM

public class Problem13 {
    public static int friendsPairing(int n) {
        // base case
        if(n == 1 || n == 2) {
            return n;
        }

        // Choice
        // Single
        int fnm1 = friendsPairing(n-1);

        // Pair
        int fnm2 = friendsPairing(n-2);
        int pairWays = (n-1) * fnm2; //with how many people can i make a pair with * ek ke saath pair bna liye phir kitne ways hai
        
        // Total Ways
        int totWays = fnm1 + pairWays;
        return totWays;

        // or another method to write in single line
        //return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    }

    public static void main(String args[]) {
        System.out.println(friendsPairing(3));
    }
}
