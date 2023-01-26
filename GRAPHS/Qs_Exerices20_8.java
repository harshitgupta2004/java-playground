// Find whether it is possible to finish all tasks or not
// There are a total of n tasks you have to pick, labelled from 0 to n-1. Some tasks may have prerequisites, 
// for example to pick task 0 you have to first pick task 1, which is expressed as a pair: [0, 1] 
// Given the total number of tasks and a list of prerequisite pairs, is it possible for you to finish all tasks?

// TC = SC = O(n)

import java.util.*;
public class Qs_Exerices20_8 {
    static class pair{
        int first, second;

        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static ArrayList<ArrayList<Integer>> makeGraph(int numTasks, Vector<pair> prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(numTasks);
        for(int i = 0; i < numTasks; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(pair pre : prerequisites) {
            graph.get(pre.second).add(pre.first);
        }

        return graph;
    }

    static int[] compute_indegree(ArrayList<ArrayList<Integer>> graph){
        int degrees[] = new int[graph.size()];

        for(ArrayList<Integer> neighbours : graph) {
            for(int neigh : neighbours) {
                degrees[neigh]++;
            }
        }
        return degrees;
    }

    static boolean canFinish(int numTasks, Vector<pair> prerequisites) {
        ArrayList<ArrayList<Integer>> graph = makeGraph(numTasks, prerequisites);
        int degrees[] = compute_indegree(graph);

        for(int i = 0; i < numTasks; i++){
            int j = 0;
            for(; j < numTasks; j++){
                if(degrees[j] == 0) {
                    break;
                }
                if(j == numTasks){
                    return false;
                }
                degrees[j] = -1;
                for(int neigh : graph.get(j)){
                    degrees[neigh]--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numTasks = 4;
        Vector<pair> prerequisites = new Vector<pair>();
        
        prerequisites.add(new pair(1, 0));
        prerequisites.add(new pair(2, 1));
        prerequisites.add(new pair(3, 2));
        
        if (canFinish(numTasks, prerequisites)) {
            System.out.println("Possible to finish all tasks");
        }
        else {
            System.out.println("Impossible to finish all tasks");
        }
    }
}
