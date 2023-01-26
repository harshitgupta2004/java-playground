// Remove DUPLICATES in a String

public class Problem12 {

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        //base case
        if(idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        // kaam -> take out a charcter and check that it exists in the map or not?
        char currChar = str.charAt(idx);
        if(map[currChar-'a'] == true) {
            // duplicate
            removeDuplicates(str, idx+1, newStr, map); //call for next index
        } else {
            map[currChar-'a'] = true;
            removeDuplicates(str, idx+1, newStr.append(currChar), map);
        }
    }
    public static void main(String args[]) {
        String str = "appnnacollege";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}