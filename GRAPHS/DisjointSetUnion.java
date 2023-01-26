public class DisjointSetUnion {

    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() { // initialize
        for(int i = 0; i < n; i++){
            par[i] = i; // everyone is par of itself initially
        }
    }

    public static int find(int x) {
        if(x == par[x]){
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            par[parB] = parA; // b joins to a
            rank[parA]++;
        } else if(rank[parA] < rank[parB]){
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    // path compression -> apko baar -2 par find krne ki jagah (find(par[x])) , so directly apna jo leader hai na , par ke par ka par jo ancestor hai usko hi store karwa lun jb find fxn call hota hai
    public static void main(String[] args) {
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }
}
