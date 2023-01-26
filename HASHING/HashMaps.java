import java.util.*;

public class HashMaps {
    public static void main(String args[]) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert
        hm.put("India", 100);
        hm.put("US", 50);
        hm.put("China", 150);

        System.out.println(hm);

        // Get 
        int population = hm.get("India");
        System.out.println(population);

        // containskey
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("UK"));

        // Remove
        System.out.println(hm.remove("China"));
        System.out.println(hm);

        // Size
        System.out.println(hm.size());

        // isempty
        System.out.println(hm.isEmpty());

        // clear fxn
        hm.clear();
        System.out.println(hm.isEmpty());
    }
}