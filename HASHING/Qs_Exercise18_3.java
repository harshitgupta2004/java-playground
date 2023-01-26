import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Sort By Frequency
// Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
// Return the sorted string. If there are multiple answers, return any of them.


public class Qs_Exercise18_3 {
    public static String frequencySort(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());

        for(Map.Entry<Character, Integer> e:map.entrySet()) {
            pq.add(e);
        }

        StringBuilder res = new StringBuilder();
        while(pq.size() != 0){
            char ch = pq.poll().getKey();
            int val = map.get(ch);
            while(val != 0){
                res.append(ch);
                val--;
            }
        }

        return res.toString();
    }

    public static void main(String args[]) {
        String s = "cccaaa";
        System.out.println(frequencySort(s));
    }
}
