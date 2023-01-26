import java.util.PriorityQueue;

public class ConnectingCities {

    // this, time instead of making complete adj list, we gonna store the edges -> how to store info for edges? for edges, we already know the source like 0 wale idx pe hai to 0 wali source hai, 1 wale idx pe hai to 1 wali src hai, and so on
    static class Edge implements Comparable<Edge>{
        int dest;
        int cost;

        public Edge (int d, int c){
            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost; // ascending
        }
    }

    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new Edge(0, 0));
        int finalCost = 0;

        while(! pq.isEmpty()) {
            Edge curr = pq.remove();
            if(! vis[curr.dest]){
                vis[curr.dest] = true;
                finalCost += curr.cost; // jiss edge ko include kr rha hun uski cost bhi add kr dun ans me

                // loop for all neighbours
                for(int i= 0; i < cities[curr.dest].length; i++){
                    if(cities[curr.dest][i] != 0){ // neigh tk koi edge exist krta hai, if edge exits, add it to pq also
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    } 
                }
            }
        }

        return finalCost;
    }
    public static void main(String args[]) {
        int cities[][] = {{0, 1, 2, 3, 4},
                          {1, 0, 5, 0, 7},
                          {2, 5, 0, 6, 0},
                          {3, 0, 6, 0, 0},
                          {4, 7, 0, 0, 0}};

        System.out.println(connectCities(cities));
    }
}
