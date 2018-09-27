package SearchingSorting;

/**
 * MergeSort Best Ω(n log(n))	Worst O(n log(n))
 *
 * Created on 23 Aug 2018
 *
 * @author happygirlzt
 *
 */
public class MergeSort1 {
    public static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) >> 1;

            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);

            merge(nums, l, mid, r);
        }
    }

    public static void merge(int[] nums, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] Left = new int[n1];
        int[] Right = new int[n2];

        // Copy the values to Left and Right
        for (int i = 0; i < n1; i++) {
            // Cannnot treat l as 0 by default
            Left[i] = nums[l + i];
        }

        for (int j = 0; j < n2; j++) {
            Right[j] = nums[j + mid + 1];
        }

        int i = 0, j = 0;

        // k is the index of nums
        int k = l;
        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                nums[k] = Left[i];
                i++;
            } else {
                nums[k] = Right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = Left[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = Right[j];
            j++;
            k++;
        }

        // nums;
    }

    public static void main(String[] args) {
        int[] a = { 3, 5, 8, 2, 1, 0, -3 };
        mergeSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
