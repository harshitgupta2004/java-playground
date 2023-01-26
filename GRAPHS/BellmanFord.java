import java.util.ArrayList;

public class BellmanFord {
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


    // Edge[]
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    // below createGraph2 is more simple for Bellman Ford Algo
    // new graph -> AL of edges not array
    // now there is no array, so its not adding on basis of index; now simpley edges info is added, randomly all edges added
    static void createGraph2(ArrayList<Edge> graph) {
        
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for(int i = 0; i < dist.length; i++){
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        // Total TC = O(V * E) -> O(E) wala loop V times run ho rha hai
        // Algo - O(V) 
        for(int i = 0; i < V-1; i++){
            // edges- O(E) -> both loops are finding all the edges, so jitne edge, utni tc 
            for(int j = 0; j < graph.length; j++){ // get all vertices by j loop
                for(int k = 0; k < graph[j].size(); k++){ // for each vertex, we get all edges
                    Edge e = graph[j].get(k);
                    // u, v, wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // relaxation step
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){ // In java, C++, if any integer is added to Integer.MAX_VALUE, so it will make it a negative value, so it will always be less than dist[v] and would give wrong ans
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // print
        for(int i = 0; i < dist.length; i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();

    }

    // when we take createGraph2 :-
    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V) {
        int dist[] = new int[V];
        for(int i = 0; i < dist.length; i++){
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < V-1; i++){ 
            for(int j = 0; j < graph.size(); j++) {
                Edge e = graph.get(j);
                // u, v, wt
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // relaxation step
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){ 
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // print
        for(int i = 0; i < dist.length; i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();

    }

    public static void main(String args[]) {
        int V = 5;
        //ArrayList<Edge> graph[] = new ArrayList[V];
        ArrayList<Edge> graph = new ArrayList<>(); // in which all edges are stored
        createGraph2(graph);

        bellmanFord2(graph, 0, V);
    }
}