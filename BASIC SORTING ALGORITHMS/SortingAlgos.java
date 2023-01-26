public class SortingAlgos {

// BUBBLE SORT
// TC = O(n^2); but optimized method have TC = O(n)


    public static void bubbleSort(int arr[]) {
        for(int turn = 0; turn < arr.length-1; turn++){
            for (int j = 0; j < arr.length-1-turn; j++){
                if (arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void optimizedbubbleSort(int arr[]) {
        for(int turn = 0; turn < arr.length-1; turn++){
            boolean swaps;
            swaps = false;

            for (int j = 0; j < arr.length-1-turn; j++){
                if (arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps = true;
                }
            }
            //if no elements were swapped by inner loop, then break
            if (swaps == false)
                break;
        }
    }    

    public static void printArr(int arr[]) { //here we replace int arr[] with Integer arr[] only for Collection reverse order
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }



// SELECTION SORT
// TC = O(n^2)
 
    public static void selectionSort(int arr[]){
        for(int i = 0; i < arr.length-1; i++ ){ // outer lopp - count turns
            int minPos = i; //min position - we will consider our current element as the min(smallest)
            for(int j = i+1; j < arr.length; j++){ // here we starts j with i+1 because, i tk hamara paas sara sorted hissa hai and unsorted hissa start ho rha hai i+1 se // j = i+1 ---- shows the start of unsorted array
                if(arr[minPos] > arr[j]){ //if we change > with < this, ten we will get array in increasing order as it will firstly find largest and put it in the starting
                    minPos = j;
                }
            }
            // swap
            int temp = arr[minPos];
            arr[minPos] = arr[i]; // agr 0th index keliye comparison ho rha hai to hum 1st smallest dhundh rhe hain; jaise 1th position me liye comparison ho rha hai to mtlb 2nd smallest dhundna cha rhe hain
            arr[i] = temp;
        }
    }



// INSERTION SORT
// TC = O(n^2)

    public static void insertionSort(int arr[]) {
        //outer loop 
        for (int i = 1; i < arr.length; i++){
            int curr = arr[i]; //ye current temp memory me uss element ko hi store kr lega 
            int prev = i-1; //previous element
            //finding out the correct pos to insert
            while(prev >= 0 && arr[prev] > curr){
                arr[prev+1] = arr[prev]; //previous element ke agle wale index pe usko push kr diya hai agr vo bada hai current se 
                prev--;
            }
            //insertion
            arr[prev+1] = curr; 
        }
    }



// COUNTING SORT
// TC = O(n)
    public static void countingSort(int arr[]) {
        //here we count frequency
        int largest = Integer.MIN_VALUE; //to find range or largest no
        for(int i = 0; i < arr.length; i++){
            largest = Math.max(largest, arr[i]);
        }

        //here we create a count array
        int count[] = new int[largest+1]; //+1 isliye kunki hum 0 se leke 7 tk le jayenge agr 7 hai range to, to 7 bhi include hona chahiye
        for (int i = 0; i < arr.length; i++){
            count[arr[i]]++;
        }

        //this loop is used for sorting
        // here we itrate over count array
        int j = 0; //here, orginal array ke andar 0 se shuruat kr di
        for(int i = 0; i < count.length; i++){
        // for(int i = count.length-1; i >= 0; i--) //for descending order use this
            while(count[i] > 0){
                arr[j] = i; // jb tk count ki value 0 nhi ho jaati tb tk apne original array me uss number ko daalte jayenge
                j++; // orginal array ka index aage badayenge
                count[i]--; // count ko -- kr denge because jb mtlb hum frequency ko 2 se 1 krte hain phir 0, vo isse hoga
            }
        }
    }
    public static void main (String args[]) {
        int arr[] = {5, 4, 1, 3, 2};
        // insertionSort(arr);

        //INBUILT SORT
        // Arrays.sort(arr); 

        // or anothe method in which you want to sort a particular part of array
        // Arrays.sort(arr,0,3); //ending index is non inclusive so you have to write ei as +1 from the index you want to find
        
        // for reverse order / descending order to get we need Collections framework
        // but fot that we need an object array
        // and ye jo array humne bnaya tha vo primitive type ka tha, to hum isse object type bnayenge
        
        // Integer arr[] = {5,1,4,3,2}; //here this array is defined as an object bcoz Collecions reverse order fxn humesha object pe kaam krta hai
        // Arrays.sort(arr, Collections.reverseOrder());
        
        // OR with Indexes
        // Arrays.sort(arr, 0, 3, Collections.reverseOrder());
        // here reverseOrder fxn uses a comparitor to compare inside java, so it basically reverses the logic, mtlb ki b agr bada hai to usse aage le ao
        // countingSort(arr);
        selectionSort(arr);
        printArr(arr);
    }
}
