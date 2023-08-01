public class MobileNumericKeypad_Seq {
    public static String printSequence(String str[], String input){
        String op = "";
        int n = input.length();
        input = input.toUpperCase();

        for(int i = 0; i < n; i++){
            if(input.charAt(i) == ' '){
                op += 0;
            }else{
                int pos = input.charAt(i) - 'A';
                op += str[pos];
            }
        }
        return op;
    }
    public static void main(String[] args) {
        String str[]
            = { "2",    "22",  "222", "3",   "33", "333",
                "4",    "44",  "444", "5",   "55", "555",
                "6",    "66",  "666", "7",   "77", "777",
                "7777", "8",   "88",  "888", "9",  "99",
                "999",  "9999" };
 
        String input = "Hi I am Harshit";
        System.out.println(printSequence(str, input));
    }
}
