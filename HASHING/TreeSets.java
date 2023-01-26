import java.util.HashSet;
import java.util.TreeSet;

public class TreeSets {
    public static void main(String args[]) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Noida");
        cities.add("Mumbai");
        cities.add("Chandigarh");
        System.out.println(cities);

        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Noida");
        ts.add("Mumbai");
        ts.add("Chandigarh");
        System.out.println(ts);
    }
}
