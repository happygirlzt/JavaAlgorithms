/**
 * Created on 23 Aug 2018
 * 
 * @author happygirlzt
 *
 */
public class MergeSort1 {
	// merge
	public static int[] merge(int[] nums, int l, int m, int r) {

		int[] n1 = new int[m - l + 1];
		int[] n2 = new int[r - m];

		// Copy data to temp arrays
		for (int i = 0; i < n1.length; i++) {
			n1[i] = nums[l + i];
		}

		for (int j = 0; j < n2.length; j++) {
			n2[j] = nums[m + j + 1];
		}

		int i = 0, j = 0;
		int k = l;
		while (i < n1.length && j < n2.length) {
			if (n1[i] < n2[j]) {
				nums[k] = n1[i];
				i++;
			} else {
				nums[k] = n2[j];
				j++;
			}

			k++;
		}

		while (i < n1.length) {
			nums[k] = n1[i];
			i++;
			k++;
		}

		while (j < n2.length) {
			nums[k] = n2[j];
			j++;
			k++;
		}

		return nums;
	}

	// Recursive
	public static void mergeSort(int[] nums, int l, int r) {
		if (l < r) {
			int m = (l + r) >> 1;

			// Sort the first part
			mergeSort(nums, l, m);
			mergeSort(nums, m + 1, r);

			merge(nums, l, m, r);
		}
	}

	public static void main(String[] args) {
		int[] a = { 3, 5, 8, 2, 1, 0, -3 };
		mergeSort(a, 0, a.length - 1);
	}
}
