import java.util.*;

public class Weakest_Soldier {

    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) { // if equal, compareTo returns 0 -> means take row1 at front or r0, doesn't matter as they are equal
            if(this.soldiers == r2.soldiers) {
                return this.idx - r2.idx; // sort on basis of idx
            } else {
                return this.soldiers - r2.soldiers; // sort on basis of count of soldiers
            }
        }
    }

    public static void main(String args[]) {
        int army[][] = {{1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0}};
        
        int k = 2;

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i = 0; i < army.length; i++){
            int count = 0;
            for(int j = 0; j < army[0].length; j++){ // count soldiers in a row
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }

        for(int i = 0; i < k; i++){
            System.out.println("R" + pq.remove().idx);
        }
    }
    
}
