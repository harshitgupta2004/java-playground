import java.util.*;

public class IterationHS {
    public static void main(String args[]) {
        HashSet<String>  cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bangalore");

        // using Iterator
        Iterator it = cities.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        // using enhanced for loop
        // for(String city : cities){
        //     System.out.println(city);
        // }
    }
}
