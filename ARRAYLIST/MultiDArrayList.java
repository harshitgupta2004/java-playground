import java.util.ArrayList;

public class MultiDArrayList {
    
    public static void main(String args[]) {
        // Creating a mainList -> which will be an AL of an AL of Integer type
        ArrayList <ArrayList <Integer> > mainList = new ArrayList<>(); 

        // Creating list which we want to store in mainList
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1); list1.add(2);

        // Now, we can add this list1 to the mainlist
        mainList.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3); list2.add(4);
        mainList.add(list2);

        // Firstly, we traverse through mainList to get each lists stored in the mainList
        for(int i = 0; i < mainList.size(); i++) {
            ArrayList <Integer> currList = mainList.get(i); // This mainList.get(i) gives us the list stored in the mainList at index i
            for(int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) +" ");
            }
            System.out.println();
        }

        System.out.println(mainList);
        // All lists in this mainList can have diff sizes, its not necessary tha these lists should have same size

        // Now, to add 3 lists given in the question 
        ArrayList<ArrayList<Integer>> mainList2 = new ArrayList<>();
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        ArrayList<Integer> listC = new ArrayList<>();

        for(int i = 1; i <= 5; i++ ) {
            listA.add(i*1); // 1 2 3 4 5
            listB.add(i*2); // 2 4 6 8 10
            listC.add(i*3); // 3 6 9 12 15
        }

        mainList2.add(listA);
        mainList2.add(listB);
        mainList2.add(listC);

        for(int i = 0; i < mainList2.size(); i++) {
            ArrayList<Integer> curList2 = mainList2.get(i);
            for(int j = 0; j < curList2.size(); j++) {
                System.out.print(curList2.get(j) + " ");
            }
            System.out.println();
        }

        System.out.println(mainList2);
    }
}
