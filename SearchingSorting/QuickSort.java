package SearchingSorting;

import java.util.Arrays;

/**
 * QuickSort - Best Ω(n log(n))	 Worst O(n^2)
 * 
 * Created on 2018-08-28
 * 
 * @author happygirlzt
 *
 */

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