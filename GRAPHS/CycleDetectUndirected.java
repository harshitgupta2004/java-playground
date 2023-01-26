import java.util.ArrayList;

public class CycleDetectUndirected {
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

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean [graph.length];
        for(int i = 0; i < graph.length; i++){
            if(! vis[i]){ // my node not visited -> so visit it // why we check again & again that is it non visited ? why we use a loop ? bc we have to check for all compo. of graph 
                if(detectCycleUtil(graph, vis, i, -1)){ // src doesn't have a parent so -1 
                    return true;
                    // cycle exists in one of the parts
                }
            }
        }

        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            // Case 3:
            if(! vis[e.dest]){ // if my neigh is unvisited 
                if(detectCycleUtil(graph, vis, e.dest, curr)){ // after visiting it -> after calling util if it gives True, then, that means cycle exists // bc mere through call jaa rhi hai, so I (curr) wil become neigh's parent
                    return true;
                }
            }

            // Case 1:
            else if(vis[e.dest] && e.dest != par){
                return true;
            }

            // Case 2: -> do nothing -> continue
        }

        return false;
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println(detectCycle(graph));
    }
}
