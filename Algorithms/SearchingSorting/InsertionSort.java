package SearchingSorting;

/**
 * Time complexity is O(n^2)
 */
public class InsertionSort{

    public static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i ++) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1],
               that are greater than key, to one
               position ahead of their current
               position */
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j = j - 1;
            }

            arr[j+1] = key;
        }
    }

    /* Print array of size n */
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // UPD on 18 Sep 2018

    public static void insertionSort1(int[] list) {
        for (int i = 1; i < list.length; i++) {
            /** Insert list[i] into a sorted sublist list[0...i-1] so that
             list[0...i] is sorted */
            int cur = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > cur; k--) {
                list[k + 1] = list[k];
            }

            // Insert the current element into list[k + 1]
            list[k + 1] = cur;
        }
    }


    public static void main(String[] args) {
        int arr[] = {12, 11, 14, 23, 2};

        insertionSort(arr);

        printArray(arr);
    }
}
