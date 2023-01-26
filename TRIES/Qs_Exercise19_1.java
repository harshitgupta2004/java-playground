import java.util.*;

// Group Anagrams Together
// Given an array of strings strs, group the anagrams together. You can return the answer in any order. 

public class Qs_Exercise19_1 {
    static class TrieNode{
        List<String> data;
        TrieNode children[];
        boolean isEnd;

        public TrieNode() {
            data = new ArrayList<>();
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    static TrieNode root;
    static List<List<String>> ans;

    public static List<List<String>> groupAnagrams(String strs[]) {
        ans = new ArrayList<>();

        root = new TrieNode();

        for(String word : strs ){
            build(word);
        }

        dfs(root);

        return ans;
    }

    public static void build(String s) {
        TrieNode temp = root;
        char word[] = s.toCharArray();
        Arrays.sort(word);
        for(char c : word){
            TrieNode child = temp.children[c-'a'];
            if(child == null) {
                temp.children[c-'a'] = new TrieNode();
            }
            temp = temp.children[c-'a'];
        }

        temp.isEnd = true;
        temp.data.add(s);
    }

    public static void dfs(TrieNode rt) {
        if(rt.isEnd){
            ans.add(rt.data);
        }

        for(int i = 0 ; i < 26; i++){
            if(rt.children[i] != null) {
                dfs(rt.children[i]);
            }
        }
    }

    public static void main(String args[]) {
        String wordArr[] = {"cat", "dog", "tac", "god", "act", "gdo"};
        System.out.println(groupAnagrams(wordArr));
    }
}
