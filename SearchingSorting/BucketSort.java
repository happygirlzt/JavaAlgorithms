package SearchingSorting;

// Time complexity of the algorithm is O(n)

public class BucketSort {
    public static void display(int[] arr, int size) {
        int i;
        for (i = 0; i < size; i ++) {
            System.out.println(arr[i] + " ");
        }
        System.out.print("\n");
    }

    public static int getMax(int[] arr, int size) {
        int m = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > m) {
                m = arr[i];
            }
        }

        return m;
    }

    public static int[] bucketSort(int[] arr, int maxValue) {

        // Bucket Sort
        int[] Bucket = new int[maxValue + 1];
        int[] sorted_sequence = new int[arr.length];

        for (int i = 0; i < arr.length; i++)
            Bucket[arr[i]]++;

        int outPos = 0;
        for (int i = 0; i < Bucket.length; i ++)
            for (int j = 0; j < Bucket[i]; j++)
                sorted_sequence[outPos++] = i;

        return sorted_sequence;
    }

    public static void main(String[] args) {
        int[] num = {3, 5, 1, 8, 2, 7, 9, 3, 5};
        int n = num.length;
        int maxVal = getMax(num, n);

        display(bucketSort(num, maxVal), n);
    }
}
