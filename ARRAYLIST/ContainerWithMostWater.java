import java.util.ArrayList;

public class ContainerWithMostWater {

    // Brute Force Approach -> TC = O(n^2)
    // public static int storeWater(ArrayList<Integer> height) {
    //     // Global Variable
    //     int maxWater = 0; //No single line makes a container

    //     for(int i = 0; i < height.size(); i++) {
    //         for(int j = i+1; j < height.size(); j++) {
    //             int ht = Math.min(height.get(i), height.get(j));
    //             int width = j - i; // difference between indexes
    //             int currWater = ht * width; // water stored by current lines we take to make a container
    //             maxWater = Math.max(maxWater, currWater);
    //         }
    //     }

    //     return maxWater;
    // }


    // 2 Pointer Approach - TC = O(n)
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size()-1;

        while(lp < rp) {
            // Calculate water area
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);

            // Update pointer -> Always update the smaller height pointer(line)
            if(height.get(lp) < height.get(rp)) {
                lp ++;
            } else {
                rp--;
            }
        }

        return maxWater;
    }
    public static void main(String args[]) {
        ArrayList <Integer> height = new ArrayList<>();
        // 1, 8, 6, 2, 5, 4, 8, 3, 7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(storeWater(height));
    }
}
