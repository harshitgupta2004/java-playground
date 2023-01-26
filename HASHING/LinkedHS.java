import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHS {
    public static void main(String args[]) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Noida");
        cities.add("Mumbai");
        cities.add("Chandigarh");
        System.out.println(cities);

        LinkedHashSet <String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Noida");
        lhs.add("Mumbai");
        lhs.add("Chandigarh");
        System.out.println(lhs);

        lhs.remove("Delhi");
        System.out.println(lhs);
    }    
}
