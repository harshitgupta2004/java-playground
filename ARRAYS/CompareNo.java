import java.util.*;

public class CompareNo {
    public static void main(String[] args) {
        int arr[] = {54, 546, 548, 60};
        System.out.println(comparing(arr));
    }

    private static String comparing(int arr[]) {
        int n = arr.length;
        String a[] = new String[n];

        for(int i = 0; i < n; i++){
            a[i] = String.valueOf(arr[i]);
        }

        String s = "";
        Collections.sort(a, new Comparator<String>(){
            @Override
            public int compare (String s, String s1){
                for(int i = 0; i < s.length() && i < s1.length(); i++){
                if(s.charAt(i) > s1.charAt(i)){
                    s += s+s1;
                }else if(s.charAt(i) < s1.charAt(i)){
                    s += s1+s;
                }
                s += s.length() > s1.length() ? s1+s : s+s1;
            }
        });
        
        return s;
    }
}
