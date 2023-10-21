// Arrange given numbers to form the biggest number

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

        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s, String s1) {
                String order1 = s + s1;
                String order2 = s1 + s;
                return order2.compareTo(order1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : a) {
            sb.append(s);
        }

        return sb.toString();
    }
}
