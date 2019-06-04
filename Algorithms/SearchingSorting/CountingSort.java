/**
 * Created on 4 Jun 2019 by happygirlzt
 *
 * Hackerearth Link: https://www.hackerearth.com/zh/practice/algorithms/sorting/counting-sort/tutorial/
 *
 */

import java.util.*;

class CountingSort {
    public static void countSort(int[] a, int[] count) {
        int[] sorted = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }

        int index = 0;

        for (int i = 0; i < count.length; i++) {
            int tmp = count[i];

            while (tmp > 0) {
                sorted[index++] = i;
                tmp--;
            }
        }

        System.arraycopy(sorted, 0, a, 0, a.length);
    }

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
            max = Math.max(max, a[i]);
        }

        int[] count = new int[max + 1];
        countSort(a, count);

        for (int i = 0; i < n; i++) {
            System.out.println(a[i] + " " + count[a[i]]);
            int tmp = count[a[i]];
            while (--tmp > 0) {
                i++;
            }
        }
    }
}
