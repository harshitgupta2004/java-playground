// Given an undirected graph and a number m, determine if the graph can be colored with at most m colors such that no two adjacent vertices of the graph are colored with the same color.
// T = O(n^m); SC = O(n)

import java.util.*;

public class M_Coloring {
    public static boolean graphColoring(List<Integer> G[], int color[], int i, int m) {
        int n = G.length;
        if (solve(i, G, color, n, m)) {
            return true;
        }
        return false;
    }

    public static boolean isSafe(int node, List<Integer> G[], int color[], int n, int m) {
        for (int i : G[node]) {
            if (color[i] == m) {
                return false;
            }
        }
        return true;
    }

    public static boolean solve(int node, List<Integer> G[], int color[], int n, int m) {
        if (node == n) {
            return true;
        }

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, G, color, n, i)) {
                color[node] = i;
                if (solve(node + 1, G, color, n, m)) {
                    return true;
                }
                color[node] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int N = 4, M = 3;
        List<Integer>[] G = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList<>();
        }

        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);

        int[] color = new int[N];
        boolean ans = graphColoring(G, color, 0, M);
        if (ans == true)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
