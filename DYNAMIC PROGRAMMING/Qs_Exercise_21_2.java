// Print all combinations of balanced parentheses
// Write a function to generate all possible n pairs of balanced parentheses

// Tc = SC = O(n)

public class Qs_Exercise_21_2 {
    public static void _printParanthesis(char str[], int pos, int n, int open, int close) {
        if(close == n) {
            for(int i = 0; i < str.length; i++){
                System.out.print(str[i]);
            }
            System.out.println();
            return;
        }
        else {
            if(open > close){
                str[pos] = '}';
                _printParanthesis(str, pos+1, n, open, close+1);
            }
            if(open < n){
                str[pos] = '{';
                _printParanthesis(str, pos+1, n, open+1, close);
            }
        }
    }
    
    public static void printParanthesis(char str[], int n) {
        if(n > 0) {
            _printParanthesis(str, 0, n, 0, 0);
        }
        return;
    }

    public static void main(String[] args) {
        int n = 2; 
        char str[] = new char[2*n];
        printParanthesis(str, n);
    }
}
