package SearchingSorting;

// Binary Search
// @happygirlzt
// Created on 19 Aug, 2018

// The worstTime(n) is O(logn)
public class BinarySearch {
    public static int binarysearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;  // same effect as (low + high) / 2

            int midVal = a[mid];

            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -(low + 1);  // not found;
    }
}
