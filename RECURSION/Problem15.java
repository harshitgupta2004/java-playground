// TOWER OF HANOI

public class Problem15 {
    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        // base class
        if (n == 1) {
            System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
            return;
        }

        // transfer top n-1 from source(src) to helper using destination(dest) as 'helper'
        towerOfHanoi(n-1, src, dest, helper);

        // transfer nth from src to dest
        System.out.println("Transfer disk " + n + " from " + src + " to " + dest);

        // transfer n-1 from helper to dest using src as 'helper'
        towerOfHanoi(n-1, helper, src, dest);
    }

    public static void main(String args[]) {
        int n = 3; //no of disks
        towerOfHanoi(n, "A", "B", "C");
    }
}
