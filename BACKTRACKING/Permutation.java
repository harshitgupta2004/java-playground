// TC = O(n * n!)
public class Permutation {

    public static void findPermuation(String str, String ans) {
        // base case
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // Recusrion -> In this, we have to take choices from the string, we have take out the char one by one and placed it at the curr pos 
        for(int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i); 

            // Now, we have to add this current char to the ans string; but before that, we want to delete this curr char from the string
            // "abcde" = "ab" + "de" = "abde" ; here c automatically removes if we take and add ab & de
            String NewStr = str.substring(0, i) + str.substring(i+1); //2nd ending index is not inclusive //Here, ith char completely removes

            findPermuation(NewStr, ans+curr);
        }
    }

    public static void main(String args[]) {
         String str = "abc";
         findPermuation(str, "");
    }
}
