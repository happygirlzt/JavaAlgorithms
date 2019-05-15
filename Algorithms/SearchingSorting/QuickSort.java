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

package SearchingSorting;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi)
            return;
        int pivotIndex = partition(nums, lo, hi);

        quickSort(nums, lo, pivotIndex);
        quickSort(nums, pivotIndex + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        // Do not forget to cast to int
        int pivotIndex = (int) (Math.random() * (hi - lo + 1) + lo);
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, hi);
        int savedHi = hi;
        hi--;
        while (lo <= hi) {
            if (nums[lo] < pivot) {
                lo++;
            } else {
                swap(nums, lo, hi);
                hi--;
            }
        }
        swap(nums, lo, savedHi);
        return lo;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] x = { 1, 2, 4, 9, 3, 7, 10 };
        System.out.println(Arrays.toString(x));

        sort(x);
        System.out.println(Arrays.toString(x));
    }
}