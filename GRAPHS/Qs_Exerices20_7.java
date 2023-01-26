// Union-Find
// Here implement Union-Find Algorithm to check whether an undirected graph contains cycle or not

// TC = O(V+E); SC = O(1)

import java.lang.*;
import java.io.*;
import java.util.*;
public class Qs_Exerices20_7 {
    int V, E;
    Edge edge[];

    class Edge {
        int src, dest;
    };

    Qs_Exerices20_7(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for(int i = 0; i < e; ++i){
            edge[i] = new Edge();
        }
    }

    int find(int parent[], int i){
        if (parent[i] == i){
            return i;
        }
        return find(parent, parent[i]);
    }
    
    void Union(int parent[], int x, int y){
        parent[x] = y;
    }

    int isCycle(Qs_Exerices20_7 graph) {
        int parent[] = new int[graph.V];

        for(int i = 0; i < graph.V; i++){
            parent[i] = i;
        }

        for(int i = 0; i < graph.E; i++){
            int x = graph.find(parent, graph.edge[i].src);
            int y = graph.find(parent, graph.edge[i].dest);

            if(x == y){
                return 1;
            }

            graph.Union(parent, x, y);
        }
        return 0;
    }

    public static void main(String[] args) {
        int V = 3, E = 3;
        Qs_Exerices20_7 graph = new Qs_Exerices20_7(V, E);
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
        
        if (graph.isCycle(graph) == 1){
            System.out.println("Graph contains cycle");
        }
        else {
            System.out.println("Graph doesn't contain cycle");
        }
    }


}
