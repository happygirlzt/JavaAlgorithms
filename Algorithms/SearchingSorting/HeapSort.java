/**
 * Creaeted on 18 Sep 2018 by happygirlzt
 *
 * Updated on 11 Jun 2019
 *
 * A heap sort uses a binary heap. It first adds all the elements to a heap
 * and then removes the largest elements successively to obtain a sorted list.
 */

import java.util.*;

public class HeapSort {
    public static void heapSort(int[] a) {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(a, i, 0);
            heapify(a, i, 0);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void heapify(int[] a, int n, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && a[left] > a[largest]) {
            largest = left;
        }

        if (right < n && a[right] > a[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(a, largest, i);
            heapify(a, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] a = {12, 11, 13, 5, 0, 2};
        int n = a.length;

        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
