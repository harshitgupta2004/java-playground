import java.util.HashMap;

public class ItineryFromTickets {

    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>(); // <to, from>

        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key); // value as new key and key as new value
        }

        for (String key : tickets.keySet()) { // exista in tickets as a key, but not exists in revMap as key
            if(! revMap.containsKey(key)){
                return key; // starting point
            }
        }

        return null;
    }
    public static void main(String args[]) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        // Starting point
        String start = getStart(tickets);
        System.out.print(start);

        for(String key: tickets.keySet()){
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }

        System.out.println();
    }
}
