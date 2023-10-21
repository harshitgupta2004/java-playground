public class Max_Min_ElmQuery {
    static int tree[]; 

    public static void init(int n) {
        tree = new int[4*n];
    }

    public static void buildTree(int i, int si, int sj, int arr[]) { // O(n)
        if(si == sj) {
            tree[i] = arr[si];
            return;
        }

        int mid = (si+sj)/2; // si+(sj-si)/2 -> we can also use this formula, as this is more optimized for larger arrays
        buildTree(2*i+1, si, mid, arr);
        buildTree(2*i+2, mid+1, sj, arr);

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]); // in ST , we initialized the max value
    } // if we have to find min, then instead of max here above, write min only

    // if min -> then instead of max, write min everywhere 
    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n-1, qi, qj);
    }

    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) { // O(logn)
        if(si > qj || sj < qi) { //no overlap
            return Integer.MIN_VALUE; // return Max_value -> in case we have to find min
        } else if(si >= qi && sj <= qj) { // complete overlap
            return tree[i];
        } else { // partial overlap
            int mid = (si+sj)/2;
            int leftAns = getMaxUtil(2*i+1, si, mid, qi, qj);
            int rightAns = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(leftAns, rightAns); // min if we want to find minimum
        }
    }

    public static void update(int arr[], int idx, int newVal) {
        arr[idx] = newVal;
        int n = arr.length;
        updateUtil(0, 0, n-1, idx, newVal);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int newVal) { // O(logn)
        if(idx < si || idx > sj) {
            return;
        }

        /* this code is just for MIN find:
        if(si == sj) {
            tree[i] = newVal;
        }
        if(si != sj) {
            tree[i] = Math.min(tree[i], newVal);
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal);
            updateUtil(2*i+2, mid+1, sj, idx, newVal);
        } */

        if(si == sj) {
            tree[i] = newVal; // update at leaf -> in that case, my newVal is my min value
        }
         
        if(si != sj) {
            tree[i] = Math.max(tree[i], newVal);
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal); // left
            updateUtil(2*i+2, mid+1, sj, idx, newVal); // right
        }
    }
    public static void main(String[] args) {
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;
        init(n);
        buildTree(0, 0, n-1, arr);

        for(int i = 0; i < tree.length; i++){
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        int max = getMax(arr, 2, 5);
        System.out.println(max);

        update(arr, 2, 20);
        max = getMax(arr, 2, 5);
        System. out.println(max);
    }
}