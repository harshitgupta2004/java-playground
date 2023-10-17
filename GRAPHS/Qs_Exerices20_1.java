// Detect cycle in an undirected graph using BFS
// We have an an undirected graph, how to check if there is a cycle in the graph? For example, the following graph has a cycle 1-0-2-1..

// TC = SC = O(V+E)

import java.util.*;
import java.util.LinkedList;
public class Qs_Exerices20_1 {

    static void addEdge(ArrayList<Integer> adj[], int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    static boolean isCyclicConnected(ArrayList<Integer> adj[], int s, int V, boolean visited[]) {
        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while(! q.isEmpty()) {
            int u = q.poll();
            for(int i = 0; i < adj[u].size(); i++){
                int v = adj[u].get(i);
                if(! visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    parent[v] = u;
                } else if (parent[u] != v) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isCyclicDisconntected(ArrayList<Integer> adj[], int V) {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        for(int i = 0; i < V; i++){
            if(! visited[i] && isCyclicConnected(adj, i, V, visited)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Integer> adj[] = new ArrayList[V];

        for(int i = 0; i < 4; i++){
            adj[i] = new ArrayList<Integer>();
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);
        
        if(isCyclicDisconntected(adj, V)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}