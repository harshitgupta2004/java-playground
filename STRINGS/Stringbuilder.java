public class stringbuilder {
    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder(""); // initialize with empty string
        // In stringbuilder there are all fxns that are in the string
        for(char ch = 'a'; ch <= 'z'; ch++){ //in this loop, from a to z all chars append one by one in the string
            sb.append(ch); //one by one we add characters from a to z
            // .append fxn - apni string ke peeche jodne ke liye; mtlb stringbuilder me jo string hai usme apne characters ko jodte aayenge
        }

        System.out.println(sb);
        System.out.println(sb.length()); //length
    }
}

// TC = O(26)
// TC = O(n^2) n->string length  //this happens when we take a string and instead of append we do +=, then this happens