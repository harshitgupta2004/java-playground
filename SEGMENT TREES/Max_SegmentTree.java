public class Max_SegmentTree {
    static int tree[]; 

    public static void init(int n) { // tree initialize
        tree = new int[4*n];
    }

    public static void buildTree(int arr[], int i, int si, int sj) { // O(n)
        if(si == sj){
            tree[i] = arr[si];
            return;
        }

        int mid = (si+sj)/2;
        buildTree(arr, 2*i+1, si, mid); // left subtree - 2*i+1
        buildTree(arr, 2*i+2, mid+1, sj); // right subtree - 2*i+2
        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

    // Queries on ST
    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) { // O(logn)
        if(si > qj || sj < qi) { // non overlapping
            return Integer.MIN_VALUE;
        }
        else if(si >= qi && sj <= qj) { // complete overlap
            return tree[i]; 
        } else { // partial overlap
            int mid = (si+sj)/2;
            int left = getMaxUtil(2*i+1, si, mid, qi, qj);
            int right = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(left, right);
        }
    }

    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n-1, qi, qj);
    }

    // Update on ST
    public static void updateUtil(int i, int si, int sj, int idx, int newVal) { // O(logn)
        if(idx > sj || idx < si) {
            return;
        } 

        tree[i] = Math.max(tree[i], newVal);
        if(si != sj) { // non leaf
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal); // left
            updateUtil(2*i+2, mid+1, sj, idx, newVal); // right
        }
    }

    public static void update(int arr[], int idx, int newVal) {
        arr[idx] = newVal;
        int n = arr.length;
        updateUtil(0, 0, n-1, idx, newVal); 
    }
    public static void main(String[] args) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;
        init(n);
        buildTree(arr, 0, 0, n-1); // 0...to 7 we have to print our values in the root node

        for(int i = 0; i < tree.length; i++){
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        // Query to get max from 2 to 5 range (idx)
        System.out.println(getMax(arr, 2, 5)); 

        // Update on ST
        update(arr, 2, 20);
        System.out.println(getMax(arr, 2, 5));
    }
}