import java.util.ArrayList;

public class PairSum1 {

    // Brute Force
    // public static boolean pairSum1(ArrayList<Integer> list, int target) {
        
    //     for(int i = 0; i < list.size(); i++) {
    //         for(int j = 0; j < list.size(); j++) {
    //             if(list.get(i) + list.get(j) == target) {
    //                 return true; // pair sum exists
    //             }
    //         }
    //     }

    //     return false;
    // }


    // 2 Pointer Approach - O(n)
    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size()-1;

        while (lp != rp) {
            // Case 1
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }

            // Case 2
            if(list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }

        return false;
    }
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        //1, 2, 3, 4, 5, 6
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 5;
        System.out.println(pairSum1(list, target));
    }
}
