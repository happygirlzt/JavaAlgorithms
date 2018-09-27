/**
 * QuickSort - Best Ω(n log(n))  Worst O(n^2)
 *
 * Created on 2018-08-28 by happygirlzt
 *
 * UPD on 18 Sep 2018
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
 */

package SearchingSorting;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] a) {
        if (a.length == 0)
            return;
        partition(a, 0, a.length - 1);
    }

    public static void partition(int[] a, int left, int right) {
        int mid = (left + right) >> 1;
        int pivot = a[mid];

        if (left > right)
            return;

        int i = left, j = right;

        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }

            while (a[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                j--;
                i++;
            }
        }

        if (left < j) {
            partition(a, left, j);
        }

        if (right > i) {
            partition(a, i, right);
        }
    }

    public static void main(String[] args) {
        int[] x = { 9, 2, 4, 7, 3, 7, 10 };
        System.out.println(Arrays.toString(x));

        quickSort(x);
        System.out.println(Arrays.toString(x));
    }
}

class QuickSort1 {
    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    public static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /** Partition the array list[first ... last]
     * Each partition place the pivot in the right place
     */
    public static int partition(int[] list, int first, int last) {
        int pivot = list[first]; // choose the first element as the pivot
        int low = first + 1;
        int high = last;

        while (high > low) {
            // search forward from left
            while (low <= high && list[low] <= pivot)
                low ++;

            // search backward from right
            while (low <= high && list[high] > pivot)
                high--;

            // Swap two elements in the list
            if (high > low) {
                int tmp = list[high];
                list[high] = list[low];
                list[low] = tmp;
            }
        }

        while (high > first && list[high] >= pivot) {
            high --;

            // Swap pivot with list[high]
            if (pivot > list[high]) {
                list[first] = list[high];
                list[high] = pivot;
                return high;
            } else {
                return first;
            }
        }
    }
}
