/* Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.
Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.
If there exists multiple such starting points, then the function must return the first one out of those. (return -1 otherwise) */

// TC = O(n); SC = O(1)

public class CircularTour {
    static class petrolPump {
        int petrol;
        int dist;

        petrolPump(int a, int b) {
            this.petrol = a;
            this.dist = b;
        }
    }

    public static int printTour(petrolPump arr[], int n) {
        int start = 0, deficit = 0, capacity = 0;
        for (int i = 0; i < n; i++) {
            capacity += arr[i].petrol - arr[i].dist;
            if (capacity < 0) {
                start = i + 1;
                deficit += capacity;
                capacity = 0;
            }
        }

        return (capacity + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        petrolPump arr[] = { new petrolPump(6, 4),
                new petrolPump(3, 6),
                new petrolPump(7, 3) };

        int n = arr.length;
        int start = printTour(arr, n);
        if (start == -1)
            System.out.print("No solution");
        else
            System.out.print("Start = " + start);

    }
}
