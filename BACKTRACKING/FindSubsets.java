public class FindSubsets {

    public static void findSubset(String str, String ans, int i) { // 2nd Sring in which we will store our ans, store our subsets;  // i is index that right now, i am asking which character that it wants to come to our subset or not
        
        // Base Case
        if(i == str.length()) {
            if(ans.length() == 0) {
                System.out.println("Null");
            } else {
                System.out.println(ans);
            }
            return;
        }

        // Recusrion
        // Yes choice
        findSubset(str, ans+str.charAt(i), i+1);
        // No choice
        findSubset(str, ans, i+1);
    }

    public static void main(String args[]) {
        String str = "abc";
        findSubset(str, "", 0);
    }
}
