import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopSort_BFS_KahnAlgo {

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

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
        for(int i = 0; i < graph.length; i++){
            // vertex at graph becomes i
            int v = i; // try to find out all edges at all the vertex
            for(int j = 0; j < graph[v].size(); j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        // add those node which have indeg = 0
        for(int i = 0; i < indeg.length; i++){
            if(indeg[i] == 0) {
                q.add(i);
            }
        }

        // BFS
        while(! q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" "); // top sort print

            for(int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;

                if(indeg[e.dest] == 0) { // if by dec , it becomes 0 , add to queue
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
    }
    
    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        
        topSort(graph);
    }
}