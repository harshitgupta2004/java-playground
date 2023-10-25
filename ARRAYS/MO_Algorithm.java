import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Query {
    int L;
    int R;

    Query(int L, int R) {
        this.L = L;
        this.R = R;
    }
}

public class MO_Algorithm {

    public static void querySum(int arr[], int n, ArrayList<Query> q, int m) {
        for (int i = 0; i < n; i++) {
            // Left and right boundaries of current range
            int l = q.get(i).L;
            int r = q.get(i).R;

            int sum = 0;
            for (int j = l; j <= r; j++) {
                sum += arr[j];
            }

            System.out.println("Sum of [" + l + ", " + r + "] is " + sum);
        }
    }

    public static void MO(int arr[], int n, ArrayList<Query> q, int m) {
        int block = (int) Math.sqrt(n); // block size

        /*
         * Function used to sort all queries so that all queries of the same block are
         * arranged together
         * and within a block, queries are sorted in increasing order of R values
         */
        Collections.sort(q, new Comparator<Query>() {
            public int compare(Query a, Query b) {
                // Different blocks, sort by block
                if (a.L / block != b.L / block) {
                    return (a.L < b.L ? -1 : 1);
                }
                // Same block, sort by R value
                else {
                    return (a.R < b.R ? -1 : 1);
                }
            }
        });

        int currL = 0, currR = 0, sum = 0;

        // traverse through all queries
        for (int i = 0; i < m; i++) {

            // l and r values of curr range
            int l = q.get(i).L;
            int r = q.get(i).R;

            // remove extra elms of previous range
            while (currL < l) {
                sum -= arr[currL];
                currL++;
            }

            while (currR > r + 1) {
                sum -= arr[currR];
                currR--;
            }

            // Add Elements of current Range
            while (currL > l) {
                sum += arr[currL - 1];
                currL--;
            }
            while (currR <= r) {
                sum += arr[currR];
                currR++;
            }
            System.out.println("Sum of [" + l + ", " + r + "] is " + sum);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 1, 3, 4, 5, 2, 8 };
        int n = arr.length;
        ArrayList<Query> q = new ArrayList<Query>();
        q.add(new Query(0, 4));
        q.add(new Query(1, 3));
        q.add(new Query(2, 4));
        int m = q.size();

        // querySum(arr, n, q, m);
        MO(arr, n, q, m);
    }
}
