import java.util.List;
import java.util.Collections;

public class BucketSort {
    static void bucketSort(int[] a, int n) {
        List<Integer>[] buckets = new List[12];

        for (int i = 0; i < n; i++) {
            int bi = a[i];

            buckets[bi].add(a[i]);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                a[index++] = buckets[i].get(j);
            }
        }
    }

    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 2, 4, 7, 3};
        int n = a.length;
        bucketSort(a, n);

        printArray(a);
    }
}
