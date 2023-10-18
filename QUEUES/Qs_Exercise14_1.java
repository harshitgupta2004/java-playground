// Generate Binary Numbers
// Given a number N. The task is to generate and print all binary numbers with decimal values from 1 to N.

// TC = Sc = O(n)

import java.util.*;
import java.util.LinkedList;

public class Qs_Exercise14_1 {

    static void generatePrintBinary(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n-- > 0) {
            String s1 = q.peek();
            q.remove();
            System.out.println(s1);
            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "1");
        }
    }
    public static void main(String args[]) {
        int n = 5;
        generatePrintBinary(n);
    }
}
