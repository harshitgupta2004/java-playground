// BINARY STRING PROBLEM
// Print all Binary Strings of size N without consecutive ones

public class Problem14 {
    
    public static void printBinStings(int n, int lastPlace, String str) {
        // base case
        if(n == 0) {
            System.out.println(str); //print empty string
            return;
        }

        // Kaam
        // if(lastPlace == 0) {
        //     // sir 0 on chair n (previous pichli chair pe)
        //     printBinStings(n-1, 0, str.append("0")); // lastPlace 0 means 0 is lastplace for the next level
        //     printBinStings(n-1, 1, str.append("1")); // lastPlace ko 1 ki tarah paas kr diya agle level ko
        // } else {
        //     printBinStings(n-1, 0, str.append("0"));
        // } 

        // Or another way
        printBinStings(n-1, 0, str+"0"); //because everytime, 0 ko to bithana hi hai
        if(lastPlace == 0) {
            printBinStings(n-1, 1, str+"1"); // mera jo string me andar 1 add hua hai, vo sirf agle level ke liye add hua hai, current level me mene nhi seat pe nhi bithaya hai (same with 0)
        }
    }

    public static void main(String args[]) {
        printBinStings(3, 0, "");
    }
}
