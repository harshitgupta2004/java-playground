// Word Ladder
// We have a dictionary, and two words ‘start’ and ‘target’ (both of same length). Find length of the smallest chain from ‘start’ to ‘target’ if it exists, 
// such that adjacent words in the chain only differ by one character and each word in the chain is a valid word i.e., it exists in the dictionary.
// It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary words is same

// TC = O(n2*m); SC = O(n*m)

import java.util.*;
import java.util.LinkedList;
public class Qs_Exerices20_5 {
    static int shortestChainLen(String start, String target, Set<String> D) {
        if(start == target) {
            return 0;
        }
        
        if (!D.contains(target)){
            return 0;
        }
        
        int level = 0, wordlength = start.length();
        Queue<String> Q = new LinkedList<>();
        Q.add(start);
        
        while (!Q.isEmpty()){
            ++level;
            int sizeofQ = Q.size();
            for (int i = 0; i < sizeofQ; ++i){
                char word[] = Q.peek().toCharArray();
                Q.remove();
                
                for (int pos = 0; pos < wordlength; ++pos){
                    char orig_char = word[pos];
                    for (char c = 'a'; c <= 'z'; ++c){
                        word[pos] = c;
                        if (String.valueOf(word).equals(target)){
                            return level + 1;
                        }
                        if (!D.contains(String.valueOf(word))){
                            continue;
                        }
                        
                        D.remove(String.valueOf(word));
                        Q.add(String.valueOf(word));
                    }
                    word[pos] = orig_char;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Set<String> D = new HashSet<String>();
        D.add("poon");
        D.add("plee");
        D.add("same");
        D.add("poie");
        D.add("plie");
        D.add("poin");
        D.add("plea");
        
        String start = "toon";
        String target = "plea";
        
        System.out.print("Length of shortest chain is: "+ shortestChainLen(start, target, D));
    }
}
