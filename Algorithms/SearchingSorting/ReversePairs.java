/**
 * Created on 16 May 2019 by happygirlzt
 *
 * Find the count of the reversed pairs in a given array
 *
 */

import java.util.*;

class ReversePairs {
    public static long count = 0;

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        mergeSort(a, 0, n - 1);
        System.out.println(count);
    }

    private static void mergeSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;

        int mid = lo + (hi - lo) / 2;

        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        int p = lo, q = mid + 1;

        int[] nums = new int[hi - lo + 1];
        int index = 0;

        while (p <= mid && q <= hi) {
            if (a[p] > a[q]) {
                count += mid - p + 1;
                nums[index++] = a[q++];
            } else {
                nums[index++] = a[p++];
            }
        }

        while (p <= mid) {
            nums[index++] = a[p++];
        }

        while (q <= hi) {
            nums[index++] = a[q++];
        }

        System.arraycopy(nums, 0, a, lo, hi - lo + 1);
    }
}
