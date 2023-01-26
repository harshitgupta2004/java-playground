import java.util.ArrayList;
import java.util.Collections;

public class ArrayLists2 {
    public static void main(String args[]) {
        
        // Print Reverse of an ArrayList O(n)
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for(int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        // Find Maximum in an ArrayList O(n)
        ArrayList <Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(5);
        list2.add(9);
        list2.add(3);
        list2.add(6);

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list2.size(); i++) {
            // if(max < list2.get(i)) {
            //     max = list2.get(i);
            // }
            // Or
            max = Math.max(max, list2.get(i));
        }
        System.out.println("Maximum is: " + max);

        // Swap 2 numbers
        int idx1 = 1, idx2 = 3;

        int temp = list2.get(idx1);
        list2.set(idx1, list2.get(idx2)); //Now, when we want to change a value at a particular index, we use set fxn
        list2.set(idx2, temp);
        System.out.println(list2);

        // Sorting an ArrayList -> got sorted in Ascending order
        Collections.sort(list2);
        System.out.println(list2);

        // Desceding order
        Collections.sort(list2, Collections.reverseOrder());
        // Comparator - These are fxn(s) in java which define logic that how to actually do the sorting
        // Comparators can also applied on objects - like in a class there are too many objects, so to sort these objects, we write comparators
        System.out.println(list2);
    }
}
