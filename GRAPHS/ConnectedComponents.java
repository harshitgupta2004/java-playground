import java.util.*;
import java.util.LinkedList;

public class ConnectedComponents {
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

        graph[0].add(new Edge(0, 1, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));
    }

    public static void bfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(! vis[i]){
                bfsUtil(graph, vis);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge> graph[], boolean vis[]) {
        Queue<Integer> q = new LinkedList<>();

        // st point = 0
        q.add(0);

        while(! q.isEmpty()){
            int curr = q.remove();

            if(! vis[curr]){ // visit cuur (means unvisited) when it is False
                System.out.print(curr +" ");
                vis[curr] = true;
                for(int i = 0; i < graph[curr].size(); i++){ // to get all neighbors of curr node
                    Edge e = graph[curr].get(i);
                    q.add(e.dest); // add neighbors to queue
                }
            }
        }
    }


    public static void dfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            dfsUtil(graph, i, vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        // visit the curr
        System.out.print(curr + " ");
        vis[curr] = true;

        // call for neighbors
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(! vis[e.dest]){ // check if neighbour visited or not
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dfs(graph);
    }
}