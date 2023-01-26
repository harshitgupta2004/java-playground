import java.util.*;

// TC = O(n)

// Different forms of this qs:

// next Greater right -> which we done in this
// next Greater Left -> just change the for loop; i from 0 to n-1
// next Smaller Right -> just change the <= condition to >= in while loop in 1st step
// next Smaller Left -> just cahnge the loop from 0 to n-1 and change <= to >=

public class NextGreaterElement {
    public static void main(String args[]) {
        int arr[] = {6, 8, 0, 1, 3};
        Stack <Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length];

        for(int i = arr.length-1; i >= 0; i--){
            // 1: while
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) { // at s.peek there is index, and we have to get the number stored at index by arr
                s.pop();
            } 

            // 2: if-else
            if(s.isEmpty()){
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[s.peek()];
            }

            // 3: push is s
            s.push(i);
        }

        for(int i = 0; i < nxtGreater.length; i++) {
            System.out.print(nxtGreater[i] + " ");
        }
        System.out.println();
    }
}
