import java.util.*;

public class CheapestFlights {

    static class Edge {
        int src;
        int dst;
        int wt;

        public Edge(int s, int d, int wt){
            this.src = s;
            this.dst = d;
            this.wt = wt;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>(); // epmty AL
        }

        // loop on flight and wherever, an edge exists, create an edge there
        for(int i = 0; i < flights.length; i++){
            int src = flights[i][0];
            int dst = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dst, wt); // we have to add this edge in our graph[]
            graph[src].add(e);
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info (int v, int c, int s){
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapestFligh(int n, int flights[][], int src, int dst, int k) {
        // create our graoh using flight
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int dist[] = new int[n];
        for(int i = 0; i < n; i++){
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0)); // intialy from src to src

        while(! q.isEmpty()) {
            Info curr = q.remove();
            // check if to reach curr, stops is less than or greater than k
            if(curr.stops > k){
                break;
            }

            for(int i = 0; i < graph[curr.v].size(); i++){
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dst;
                int wt = e.wt;

                if(curr.cost + wt < dist[v] && curr.stops <= k){ // curr.stops <= k -> bc agr curr.stops se main uske neigh tk analyze kr rha hun to abhi means curr node tk mujhe max k stops lgne chahiye, tabhi iska neigh analyze hoga, taaki neigh tk jaane me k+1 lg jaye jismese 1 mera dest ka hi ho, to usko main ignore kr skta hun. to total beech wale raaste me k stops lgenge
                    dist[v] = curr.cost + wt; // instead of dist[u], we write curr.cost here, mtlb jo mera global mene dist store kr rkha hai u wali node, usko check nhi krna; ab jo mere curr mese nikal ke cost aa rhi hai , ussi ko compare krna hai
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }

        // dist[dest]
        if(dist[dst] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dst];
        }
    }
    public static void main(String[] args) {
        int n = 4;
        int flights[][] = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}};
        int src = 0, dst = 3, k = 1;

        System.out.println(cheapestFligh(n, flights, src, dst, k));
    }
}