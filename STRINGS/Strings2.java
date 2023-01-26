public class Strings2 {

    // Check String is PALINDROME OR NOT
    // TC = O(n)
    public static boolean isPalindrome(String str) {
        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                //not a palindrome
                return false;
            } 
        }

        return true;
    }

    //SHORTEST PATH 
    //Given a route containing 4 dir (E,W,N,S), find the shortest path to reach destination
    //"WNEENESENNN"
    public static float getShortestPath(String path) {
        int x = 0, y = 0;

        for(int i = 0; i < path.length(); i++){
            //direction analyze
            char dir = path.charAt(i); //we get directions
            //South
            if(dir == 'S'){
                y--;
            }
            //North
            else if(dir == 'N'){
                y++;
            }
            //West
            else if(dir == 'W'){
                x--;
            }
            //East
            else{
                x++;
            }
        }

        int X2 = x*x; //x^2 and y^2
        int Y2 = y*y;
        return (float)Math.sqrt(X2 + Y2);
    }


    // SUBSTRING
    public static String substring(String str, int si, int ei) {
        String substr = ""; //initialize wiith empty
        for(int i = si; i < ei; i++){
            substr += str.charAt(i); //from si to ei, all characters got stored/ added to the substr
        }
        return substr;
    }


    // Print the LARGEST String - using CompareTo function- in Lexicographically order
    public static String largesString(String fruits[]) {
        //in this, we assume that 1st string is largest
        String largest = fruits[0];
        for(int i = 0; i < fruits.length; i++){
            if(largest.compareTo(fruits[i]) < 0){
                largest = fruits[i];
            }
        }

        return largest;
    }


    //Covert Letters to UPPERCASE
    // TC = O(n)
    public static String touppercase(String change) {
        StringBuilder sb = new StringBuilder("");

        // Now, we take one by one the charcters in the string and see that ki iss charcter ko capital krna ya nhi
        // if not need to , then uss character ko sb se vaise hi copy kr denge and if agr krna hua to capital krke sb me add kr denge
        char ch = Character.toUpperCase(change.charAt(0));
        sb.append(ch); 
        
        for(int i = 1; i < change.length(); i++){
            if (change.charAt(i) == ' ' && i < change.length()-1){
                sb.append(change.charAt(i)); //here the empty space appended in stringbuilder
                i++; 
                sb.append(Character.toUpperCase(change.charAt(i))); // isme andar humne charcter nikal liya ith pace wala, uske liye hunme use uppercase me convert kr diya; usko humne sb me phir append kr diya
            } else{
                sb.append(change.charAt(i));
            }
        }

        return sb.toString();
    }


    // String COMPRESSION
    // TC = O(n) - this code will run upto string length
    // We can use sb in this cause += is taking time internally and by using sb, this code will be more good or better implemented internally
    public static String compression(String compress) {
        String newStr = "";
        // this outer loop taverse one by one over the whole string
        for(int i = 0; i < compress.length(); i++){
            Integer count = 1; // make count Integer class because it needed to be onverted into string afterward
            while(i < compress.length()-1 && compress.charAt(i) == compress.charAt(i+1)){ // everytime we are comparing the current letter and the next one are the same, if they are, then count and i ko ++; if not same, then anaylize count
                count++; // while will run upto n-1 and jb tk current letter next letter ke equal hai
                i++;
            }
            newStr += compress.charAt(i);
            if(count > 1){
                newStr += count.toString(); //count ko string me convert kr liya and usko newstr me add kr diya
            }
        }

        return newStr; // it is now a compressed string
    }
    public static void main(String args[]) {
        String str = "racecar";
        String path = "WNEENESENNN";

        //SUBSTRING
        String str2 = "HelloWorld";
        // Another way by using substring function
        System.out.println(str2.substring(0, 4));
        System.out.println(substring(str2, 3, 5));

        //Largest String - Compare
        String fruits[] = {"apple", "mango", "banana"};
        System.out.println(largesString(fruits));

        //Change into Uppercase
        String change = "hi, i am harshit";
        System.out.println(touppercase(change));

        // String Compression
        String compress = "aaabbcccdd";
        System.out.println(compression(compress));
    }
}
