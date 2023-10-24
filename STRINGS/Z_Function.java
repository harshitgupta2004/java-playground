// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

// Explanation: "sad" occurs at index 0 and 6. The first occurrence is at index 0, so we return 0.

public class Z_Function {
    public static int strStr(String haystack, String needle) {
        if (haystack.startsWith(needle)) {
            return 0;
        }

        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(strStr(haystack, needle));
    }
}