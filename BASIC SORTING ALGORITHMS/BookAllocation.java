/* Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
Allocate books in such a way that:

Each student gets at least one book.
Each book should be allocated to only one student.
Book allocation should be in a contiguous manner.
You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BookAllocation {
    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n = arr.size();
        int students = 1;
        long pagesStudent = 0;

        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                pagesStudent += arr.get(i);
            } else {
                students++;
                pagesStudent = arr.get(i);
            }
        }

        return students;
    }

    // Brute Force : TC = O(N * (sum(arr[])-max(arr[])+1)), where N = size of the
    // array; SC = O(1)
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // book allocation impossible
        if (m > n) {
            return -1;
        }

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        for (int pages = low; pages <= high; pages++) {
            if (countStudents(arr, pages) == m) {
                return pages;
            }
        }
        return low;
    }

    // Binary Search; TC = O(N * log(sum(arr[])-max(arr[])+1)), where N = size of
    // the array ; SC = O(1)
    public static int findPages2(ArrayList<Integer> arr, int n, int m) {
        if (m > n) {
            return -1;
        }

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(arr, mid);

            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int n = 5;
        int m = 4;
        int ans = findPages(arr, n, m);
        int ans2 = findPages2(arr, n, m);
        System.out.println("The answer is: " + ans);
        System.out.println("The answer is: " + ans2);
    }
}
