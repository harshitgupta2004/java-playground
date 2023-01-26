public class WordBreakProblem {
    static class Node{
        Node children[] = new Node[26];
        boolean endOfWord = false;

        public Node(){
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String words) { 
        Node curr = root;
        for(int level = 0; level < words.length(); level++){
            int idx = words.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx]; 
        }

        curr.endOfWord = true;
    }

    public static boolean search(String key) { 
        Node curr = root;
        for(int level = 0; level < key.length(); level++){
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.endOfWord = true;
    }

    public static boolean wordBreak(String key) {
        if(key.length() == 0) {
            return true;
        }

        for(int i = 1; i <= key.length(); i++){
            // substring (beg idx, last idx) and last idx is not inclusive
            // sunstring(0, i) -> in first string there will be only one character of single length
            if(search(key.substring(0, i)) &&
                wordBreak(key.substring(i))){ // java treats i as beg idx by default
                    return true;
                } 
        }
        
        return false;
    }

    public static void main(String args[]) {
        String arr[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for(int i = 0; i < arr.length; i++){
            insert(arr[i]);
        }

        String key = "ilikesamsung";
        
        System.out.println(wordBreak(key));
    }
}
