import java.util.ArrayList;

// Or import java.util.*;

public class ArrayLists {
    public static void main(String args[]) {
        // In C++, there is Vector (they are also variable size) which performs the same work as ArrayList

        // ArrayList is a part of JAVA Collection Framework

        //ClassName objectName = new ClassName(); 
        // This is the syntax for defining an object; ArrayList syntax is similar as it is also a class

        // <> angular brackets shows/ tells that which type of data we want to store in this arraylist. 
        ArrayList<Integer> list = new ArrayList<>(); // we can also use Boolean, Float, String classes here

        ArrayList <String> list2 = new ArrayList<>();
        ArrayList <Boolean> list3 = new ArrayList<>();

        // Add Element
        list.add(1); // TC = O(1) to add each element 
        list.add(2);
        list.add(3);
        list.add(4);

        // Another add function -> We can add any value in an index
        list.add(1, 9); // TC = O(n); adding 9 at index 1
        System.out.println(list);

        // Get Element -> TC = O(1)
        int element = list.get(2);
        System.out.println(element);

        // Remove Element -> TC =O(n)
        list.remove(1);
        System.out.println(list);

        // Set Element at Index -> TC = O(n)
        list.set(2, 10);
        System.out.println(list);

        // Contains Element -> TC = O()
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));

        // Size of ArrayList
        System.out.println(list.size());

        // Print the arrayList
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}