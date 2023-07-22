import java.util.*;

// TC = O(V+E)

public class Tarjan_Articulation_Point {
    static class Edge {
        int src;
        int dest;

        public Edge (int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2)); 

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[], int time, boolean ap[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i); // e.src --- e.dest
            int neigh = e.dest;
            
            if(neigh == par){
                continue;
            }
            else if(vis[neigh]){
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
            else{
                dfs(graph, neigh, curr, dt, low, vis, time, ap);
                low[curr] = Math.min(low[curr], dt[neigh]);
                if(par != -1 && dt[curr] <= low[neigh]){
                    // System.out.println("AP : " + curr);;
                    ap[curr] = true; // isntead of printing above, we just gonna make true of ap[curr]
                }

                // child count inc
                children++;
            }
        }

        if(par == -1 && children > 1){
            // System.out.println("AP : " + curr);
            ap[curr] = true; // isntead of printing above, we just gonna make true of ap[curr]
        }
    }

    public static void getAP(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        // There may be condition when same AP is printed again & again in maybe a big graph
        boolean ap[] = new boolean[V];

        for(int i = 0; i < V; i++){
            if(! vis[i]){
                dfs(graph, i, -1, dt, low, vis, time, ap);
            }
        }

        // For Printing all AP's
        for(int i = 0; i < V; i++){
            if(ap[i]){
                System.out.println("AP : " + i);
            }
        }
    }
    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getAP(graph, V);
    }
}