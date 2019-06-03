/**
 * QuickSort - Best Ω(n log(n))  Worst O(n^2)
 *
 * Created on 2018-08-28 by happygirlzt
 *
 * UPD on 18 Sep 2018
 * UPD on 20 Feb 2019
 *
 * public void quickSort(int[] list) {
 *   if (list.length > 1) {
 *     select a pivot;
 *     partition list into list1 and list2 such that
 *        all elements in list1 <= pivot and
 *        all elements in list2 > pivot
 *     quickSort(list1);
 *     quickSort(list2);
 *   }
 * }
 * Time complexity: O(n) partition time
 * O(n^2) worst time, the pivot divides the array each time into one big
 * subarray with the other array empty
 * O(nlogn) best time, the pivot divides the array each into two parts of
 * about the same size. T(n) = T(n/2) + T(n/2) + n
 * Not stable
 */

// Hackerearch Link: https://www.hackerearth.com/zh/practice/algorithms/sorting/quick-sort/tutorial/

import java.util.*;

class QuickSort {
    private static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = partition(a, lo, hi);

        quickSort(a, lo, pivot - 1);
        quickSort(a, pivot + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        Random random = new Random();
        int pivotIndex = random.nextInt(hi - lo + 1) + lo;
        int pivotValue = a[pivotIndex];
        int savedPosition = hi;
        swap(a, hi, pivotIndex);
        hi--;

        while (lo <= hi) {
            if (a[lo] > pivotValue) {
                swap(a, lo, hi);
                hi--;
            } else {
                lo++;
            }
        }

        swap(a, lo, savedPosition);
        return lo;
    }

    private static void swap(int[] a, int lo, int hi) {
        int tmp = a[lo];
        a[lo] = a[hi];
        a[hi] = tmp;
    }

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        quickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
