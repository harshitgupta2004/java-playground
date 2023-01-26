import java.util.Scanner;

// CREATING AN ARRAY
// public class Array {
//     public static void main (String args[]) {
//         int marks[] = new int[5];

//         int numbers[] = {1,2,3}; // 3 size of array

//         String fruits[] = {"Apple", "Mango", "Cherry"};

//     }
// }


// INPUT/OUTPUT IN ARRAY
// public class Array {
//     public static void main (String args[]) {
//         int marks[] = new int[5];

//         Scanner sc = new Scanner(System.in);
//         marks[0] = sc.nextInt();
//         marks[1] = sc.nextInt();
//         marks[2] = sc.nextInt();

//         System.out.println("Physics marks: " + marks[0]);
//         System.out.println("Chemistry marks: " + marks[1]);
//         System.out.println("Maths marks: " + marks[2]);

//         // update the maths marks
//         // marks[2] = 100; OR OR OR 
//         // marks[2] = marks[2] + 2;
//         // System.out.println("Maths marks: " + marks[2]);

//         // to calculte percentage of marks
//         int percentage = (marks[0] + marks[1] + marks[2]) / 3;
//         System.out.println("Percentage = " + percentage + " %");

//         // LENGHT OF AN ARRAY
//         System.out.println("Length of array = " + marks.length);
//     }
// }


// ARRAYS ARE PAASED BY *REFERENCE* ALWAYS
// public class Array {
//     // ye update fxn humare array ko as arguments lega
//     public static void update(int marks[]) { //declare an array in paramete
//         for(int i = 0; i < marks.length; i++) { //stars from index 0, i can be considered as index here
//             marks[i] = marks[i] + 1;
//         }
//     }
//     public static void main (String args[]) {
//         int marks[] = {97, 98, 99};
//         update(marks);

//         // print our marks- to see if marks updated or not
//         for (int i = 0; i < marks.length; i++) {
//             System.out.print(marks[i] + " ");
//         }
//         System.out.println();


//     }
// }


// LINEAR SEARCH
// public class Array {
    
//     public static int linearSearch (int numbers[], int key){

//         for (int i = 0; i < numbers.length; i++){
//             if (numbers[i] == key){
//                 return i;
//             }
//         }

//         return -1; // mtlb hamari key exist hi ni krti array me
//     }
//     public static void main (String args[]) {
//         int numbers[] = {2, 4, 6, 8, 10, 12, 14 ,16};
//         int key = 10; //element 10 location index?
        
//         int index = linearSearch(numbers, key);
//         if (index == -1){
//             System.out.println("NOT found");
//         } else {
//             System.out.println("Key is at Index: " + index);
//         }
//     }
// }


// LARGEST NUMBER
// public class Array {

//     public static int getLargest(int numbers[]) {
//         int largest = Integer.MIN_VALUE; // -infinity most negative value
//         int smallest = Integer.MAX_VALUE; // +infinity
//         for (int i = 0; i < numbers.length; i++){
//             if (largest < numbers[i]) {
//                 largest = numbers[i];
//             }
//             if (smallest > numbers[i]){
//                 smallest = numbers[i];
//             }
//         }
//         System.out.println(smallest);
//         return largest;
//     }
//     public static void main (String args[]) {
//         int numbers[] = {1, 2, 6, 3, 5};
//         System.out.println(getLargest(numbers));
//     }
// }


// BINARY SEARCH
// public class Array {

//     public static int binarySearch(int numbers[], int key) {
//         int start = 0, end = numbers.length - 1;

//         while (start <= end){
//             int mid = (start+end) / 2;

//             // Comparisons
//             if (numbers[mid] == key){ //found
//                 return mid;
//             }
//             if (numbers[mid] < key){ //right 2nd half
//                 start = mid + 1;
//             } else { //left 1st half
//                 end = mid - 1;
//             }
//         }

//          return -1; //key does not exist in array 
//     }
//     public static void main(String args[]) {
//         int numbers[] = {2, 4, 6, 8, 10, 12, 14};
//         int key = 10;

//         System.out.println(binarySearch(numbers, key));
//     }
// }


// REVERSE AN ARRAY
// public class Array {
//     public static int reverseArray (int numbers[]){
//         int first = 0, last = numbers.length - 1;

//         while (first < last) {
//             // swap
//             int temp = numbers[last];
//             numbers[last] = numbers[first];
//             numbers[first] = temp;

//             first++;
//             last--;
//         }
//         return first;
//     }

//     public static void main (String args[]){
//         int numbers[] = {2, 4, 6, 8, 10};
        
//         reverseArray(numbers);
        
//         // print
//         for (int i = 0; i < numbers.length; i++){
//             System.out.print(numbers[i]+ " ");
//         }
//         System.out.println();
//     }
// }



// PAIRS IN AN ARRAY
public class Array {
    public static void printPairs (int numbers[]){
        int totalpairs = 0;
        for (int i = 0; i < numbers.length; i++){
            int curr = numbers[i]; // current - 2,4,6,8,10
            for (int j = i + 1; j < numbers.length; j++){
                System.out.print("(" + curr + "," + numbers[j] + ") ");
                totalpairs++;
            }
            System.out.println();
        }
        System.out.println("Total Pairs = " + totalpairs);
    }

    public static void main (String args[]){
        int numbers[] = {2, 4, 6, 8, 10};
        printPairs(numbers);
    }
}