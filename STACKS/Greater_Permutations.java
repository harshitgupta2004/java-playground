// Count natural numbers whose all permutation are greater than that number

/* There are some natural number whose all permutation is greater than or equal to that number eg. 123, whose all the permutation (123, 231, 321) are greater than or equal to 123. 
Given a natural number n, the task is to count all such number from 1 to n.*/

/* Approach : From 1 to 9, all number have this property. So, for n <= 9, output n. 
The number whose all permutation is greater than or equal to that number have all their digits in increasing order.
The idea is to push all the number from 1 to 9. Now, pop the top element, say topel and try to make number whose digits are in increasing order and the first digit is topel. To make such numbers, the second digit can be from topel%10 to 9. If this number is less than n, increment the count and push the number in the stack, else ignore. */

// TC = SC = O(x) where x is number of elements printed in output and SC because it is using stack

import java.util.Stack;

public class Greater_Permutations {
    public static int countNumber(int n) {
        int res = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= 9; i++) {
            if (i <= n) {
                s.push(i);
                res++;
            }

            while (!s.empty()) {
                int top = s.pop();
                for (int j = top % 10; j <= 9; j++) {
                    int x = top * 10 + j;
                    if (x <= n) {
                        s.push(x);
                        res++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(countNumber(n));
    }
}
