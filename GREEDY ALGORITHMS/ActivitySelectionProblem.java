import java.util.*;

public class ActivitySelectionProblem {
    public static void main(String args[]) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        // sorting -> when in qs, it is not sorted 
        int activities[][] = new int[start.length][3];
        for(int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        // something changes in the code for this

        // lambda fxn -> shortform 
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans  = new ArrayList<>(); // to store indexes of activities

        // 1st activity
        maxAct = 1;
        ans.add(activities[0][0]);
        // ans.add(0); // our 1st act
        
        //int lastEnd = end[0]; // end time of 1st act
        int lastEnd = activities[0][2];
        for(int i = 1; i < end.length; i++) {
            // if(start[i] >= lastEnd) {
            //     // activity select
            //     maxAct++;
            //     ans.add(i);
            //     lastEnd = end[i];
            // }
            if(activities[i][1] >= lastEnd) {
                // activity select
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Max Activities = " + maxAct);
        for(int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }
}