public class SegmentTree {
    static int tree[]; 

    public static void init(int n) { // tree initialize
        tree = new int[4*n];
    }

    public static int buildST(int arr[], int sti, int start, int end) {
        if(start == end){
            tree[sti] = arr[start];
            return arr[start];
        }

        int mid = (start+end)/2;
        buildST(arr, 2*sti+1, start, mid); // left subtree - 2*i+1
        buildST(arr, 2*sti+2, mid+1, end); // right subtree - 2*i+2
        tree[sti] = tree[2*sti+1] + tree[2*sti+2];
        return tree[sti];
    }

    // Queries on ST
    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        if(qj <= si || qi >= sj) { // non overlapping
            return 0;
        }
        else if(si >= qi && sj <= qj) { // complete overlap
            return tree[i]; 
        } else { // partial overlap
            int mid = (si+sj)/2;
            int left = getSumUtil(2*i+1, si, mid, qi, qj);
            int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);
            return left+right;
        }
    }

    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n-1, qi, qj); // root of ST cal sum of range from 0 to n-1
    }

    // Update on ST
    public static void updateUtil(int i, int si, int sj, int idx, int diff) { // O(logn)
        if(idx > sj || idx < si) {
            return;
        } 

        tree[i] += diff;
        if(si != sj) { // non leaf
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, diff); // left
            updateUtil(2*i+2, mid+1, sj, idx, diff); // right
        }
    }

    public static void update(int arr[], int idx, int newVal) {
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal; // update the value at idx in arr

        // segment tree updation
        updateUtil(0, 0, n-1, idx, diff); // we are starting from root (0)
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1); // 0...to 7 we have to print our values in the root node

        for(int i = 0; i < tree.length; i++){
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        // Query to get subarray sum from 2 to 5 range (idx)
        System.out.println(getSum(arr, 2, 5)); 

        // Update on ST
        update(arr, 2, 2);
        System.out.println(getSum(arr, 2, 5));
    }
}