public class Insert_Search_Trie {
    static class Node{
        Node children[] = new Node[26];
        boolean endOfWord = false;

        Node(){
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String words) { // O(L) -> length of largest word
        Node curr = root;
        for(int level = 0; level < words.length(); level++){
            int idx = words.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx]; // for next level, my child node will become my current 
        }

        // last node reaches -> last letter of word
        curr.endOfWord = true;
    }

    public static boolean search(String key) { // O(L)
        Node curr = root;
        for(int level = 0; level < key.length(); level++){
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }

        // last node reaches -> last letter of key
        return curr.endOfWord = true;
    }

    public static void main(String args[]) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};
        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }

        System.out.println(search("thee"));
        System.out.println(search("thor"));
    }
}
