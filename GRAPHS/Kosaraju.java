import java.util.*;

// TC = O(V+E) ; same as DFS
public class Kosaraju {
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

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        // visit the curr
        vis[curr] = true;
        System.out.print(curr + " ");

        // call for neighbors
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(! vis[e.dest]){ // check if neighbour visited or not
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(! vis[e.dest]){
                topSort(graph, e.dest, vis, s); 
            }
        }

        s.push(curr);
    }

    public static void Kosarajualgo(ArrayList<Edge> graph[], int V){
        // Step 1 : Get nodes in stack (by top sort)
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(! vis[i]){
                topSort(graph, i, vis, s);
            }
        }

        // Step 2 : Transpose graph - only edges dir opp
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i = 0; i < graph.length; i++){
            vis[i] = false; // we have to use above bool vis arr, so we re-initialize here - for every index now, its false so we can use it later on 
            transpose[i] = new ArrayList<>();
        }

        for(int i = 0; i < V; i++){
            for(int j = 0; j < graph[i].size(); j++){
                Edge e = graph[i].get(j); // e.src -> e.dest
                transpose[e.dest].add(new Edge(e.dest, e.src)); // e.dest -> e.src : reverse edge
            }
        }

        // Step - 3: Do DFS acc to stack nodes in tanspose graph
        while(! s.isEmpty()){
            int curr = s.pop();
            if(! vis[curr]){
                System.out.print("SCC -> ");
                dfs(transpose, curr, vis); // scc printed
                System.out.println();
            }
        }

    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        Kosarajualgo(graph, V);
    }
}
