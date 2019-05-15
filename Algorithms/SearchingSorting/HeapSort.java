/**
 * Creaeted on 18 Sep 2018 by happygirlzt modified on 22 Jan 2019
 *
 * A heap sort uses a binary heap. It first adds all the elements to a heap
 * and then removes the largest elements successively to obtain a sorted list.
 */

package SearchingSorting;

public class HeapSort {
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void sort(int[] a) {
        int n = a.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(a, 0, i);
            heapify(a, i, 0);
        }
    }

    public static void heapify(int[] a, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && a[l] > a[largest]) {
            largest = l;
        }

        if (r < n && a[r] > a[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(a, i, largest);

            heapify(a, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] a = {12, 11, 13, 5, 0, 2};
        int n = a.length;

        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
