import java.util.*;

public class HashMapImplementation {
    static class HashMap<K, V> { // internal impelementation // k, v are generic -> parameter types, type is not fixed rn, it is general 
        private class Node { // LL in bucket, its nodes stored here
            K key; // key type is k
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n -> total no of nodes
        private int N;
        private LinkedList<Node> buckets[]; //type of array is LL here;  this is my arr of buckets ; N - total no of buckets / buckets.length

        @SuppressWarnings("umchecked") // we did not check that what type of ll is formed in array, to suppress that warning

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4]; // bucket created of size 4
            for(int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>(); // at every index, a LL is created (empty LL is initialized)
            }
        }

        private int hashFunction(K key){
            // use hashCode fxn
            int hc = key.hashCode(); // we get int type value from hashCode
            // that code can be 12323 or -12628
            // so, firstly find absolute value of that
            return Math.abs(hc) % N; // this val always lies b/w 0 to size-1 // buckets.length = N
        }

        private int SearchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0; // data idx

            for(int i = 0; i < ll.size(); i++){ 
                Node node = ll.get(i); // node found
                if(node.key == key) { // compare node with key
                    return di;
                }
                di++;
            }
            return -1; // if not found
        }

        @SuppressWarnings("Unchecked")
        private void rehash() {
            // store curr data somewehere
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];
            N = 2*N;
            for(int i = 0; i < buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }

            // nodes -> add in new bucket
            for(int i = 0; i < oldBucket.length; i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j = 0; j < ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            } 
        }

        public void put(K key, V value) { // O(lambda) -> cont - O(1)
            // find bucket index
            int bi = hashFunction(key); // idx value from 0 to size-1 (i.e. 3 here)

            // search on LL and returns data index -> we get at what index of LL where we gonna store node
            int di = SearchInLL(key, bi); // 2 cases -> valid, -1(not exists, have to create it)

            if(di != -1) {
                Node node = buckets[bi].get(di); // buckets ke andar bi index pr apne array ke andar mene idx found kra, ab LL ke andar di idx pr jaakar node nikal diya
                node.value = value; // update the value
            } else {
                buckets[bi].add(new Node(key, value)); // new node add
                n++;
            }

            double lambda = (double)n/N;
            if(lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di != -1) { // valid
                return true;
            } else {
                return false;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di != -1) { // valid
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di != -1) { // valid
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for(int i = 0; i < buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("IND", 100);
        hm.put("China", 150);
        hm.put("Nepal", 5);
        hm.put("US", 50);

        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println(hm.get("IND"));
        System.out.println(hm.remove("China"));
        System.out.println(hm.get("China"));

    }
}
