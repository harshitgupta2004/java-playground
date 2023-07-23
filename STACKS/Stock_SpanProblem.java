import java.util.*;

public class Stock_SpanProblem {

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1; // 0th index
        s.push(0);

        for(int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i]; // today's price
            // compare today price with other days prices
            while(!s.isEmpty() && currPrice > stocks[s.peek()]){ //s.peek() gives the index
               s.pop();
            }
            // Now, after removing, the one at the top which we will peek will be our prev high
            if(s.isEmpty()) {
                span[i] = i+1; // for 100 element
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i); // push our index at the stack
        }
    }
    public static void main(String args[]) {
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);

        for(int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
