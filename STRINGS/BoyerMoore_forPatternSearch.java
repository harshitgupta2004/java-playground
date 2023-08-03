public class BoyerMoore_forPatternSearch {
    static int no_of_chars = 256;

    static int max(int a, int b){
        return (a>b) ? a:b;
    }

    // Bad Character Heuristic

    // The idea of bad character heuristic is simple. The character of the text which doesn’t match 
    // with the current character of the pattern is called the Bad Character. Upon mismatch, 
    // we shift the pattern until – The mismatch becomes a match. & 
    // Pattern P moves past the mismatched character.

    public static void badCharHeuristic(char[] pat, int size, int[] badchar){
        for(int i = 0; i < badchar.length; i++){
            badchar[i] = -1;
        }

        // Fill the actual value of last occurrence of a character 
        // (indices of table are ascii and values are index of occurrence)
        for(int i = 0; i < size; i++){
            badchar[(int) pat[i]] = i;
        }
    }

    public static void search(char[] txt, char[] pat){
        int n = txt.length;
        int m = pat.length;

        int badchar[] = new int[no_of_chars];
        badCharHeuristic(pat, m, badchar);

        int s = 0; // s is shift of the pattern with respect to text
        
        // There are n-m+1 potential alignments
        while(s <= (n-m)){
            int j = m-1;

            // Keep reducing index j of pattern while characters of pattern and text are 
            // matching at this shift s

            while(j >= 0 && pat[j] == txt[s+j]){
                j--;
            }

            // If the pattern is present at current shift, then index j will become -1 after the above loop 
            if(j < 0){
                System.out.println("Patterns occur at shift = " + s);
                /* Shift the pattern so that the next character in text aligns with the last occurrence
                of it in pattern. The condition s+m < n is necessary for the case when pattern 
                occurs at the end of text txt[s+m] is character after the pattern in text */
                s += (s+m < n) ? m-badchar[txt[s+m]] : 1; 
            }
            else{
                s += max(1, j-badchar[txt[s+j]]);
            }
        }
    }
    public static void main(String[] args) {
        char txt[] = "ABAAABCD".toCharArray();
        char pat[] = "ABC".toCharArray();
        search(txt, pat);
    }   
}
