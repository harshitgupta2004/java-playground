import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkastra_Algorithm {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge (int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair>{
        int n; // node
        int path;

        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path; // path based sorting for my pairs
        }
    }
    public static void dijkastra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length]; // dits[i] -> src to i; stores all distances to nodes
        for(int i = 0; i < graph.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE; // +infinity
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0)); // form src to src

        //loop
        while(! pq.isEmpty()){
            Pair curr = pq.remove(); // the one which have shortest dist will be removed forst from pq
            if(! vis[curr.n]){ // current.node is not visited
                vis[curr.n] = true;
                // update neighbours dist
                for(int i = 0; i < graph[curr.n].size(); i++){ // curr is a pair value, but we need an index (we want .node value) 
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]){ // update dist of src to v
                        dist[v] = dist[u] + wt;
                        // push to pq
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // print all src to vertices shortest dist
        for(int i = 0; i < dist.length; i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 0;
        dijkastra(graph, src);
    }
}
