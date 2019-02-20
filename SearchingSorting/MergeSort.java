package SearchingSorting;

import java.util.Arrays;

/**
 * Stable
 * Time Complexity: O(NlogN) in all cases
 * Space Complexity: O(N)
 */
public class MergeSort {
    public static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, mid + 1, hi);
    }

    // lo0 - hi0, lo1 - hi2
    private static void merge(int[] nums, int lo0, int hi0, int lo1, int hi1) {
        int size1 = hi0 - lo0 + 1;
        int size2 = hi1 - lo1 + 1;
        int[] a1 = new int[size1];
        System.arraycopy(nums, lo0, a1, 0, size1);
        int[] a2 = new int[size2];
        System.arraycopy(nums, lo1, a2, 0, size2);

        /*
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(nums));
        */

        // ATTENTION: this is lo0, not 0
        int index = lo0;
        int i = 0, j = 0;
        while (i < size1 && j < size2) {
            if (a1[i] <= a2[j]) {
                nums[index++] = a1[i++];
            } else {
                nums[index++] = a2[j++];
            }
        }

        while (i < size1) {
            nums[index++] = a1[i++];
        }

        while (j < size2) {
            nums[index++] = a2[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = { 3, 5, 8, 2, 1, 0, -3 };
        System.out.println(Arrays.toString(a));
        
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
