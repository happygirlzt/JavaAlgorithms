/**
 * Created on 2 Oct 2018 by happygirlzt
 *
 * KMP algorithm
 */

public class KMP {
    void preKmp(char[] x, int m, int[] kmpNext) {
        int i, j;
        i = 0;
        j = kmpNext[0] = -1;

        while (i < m) {
            while (j > -1 && x[i] != x[j]) {
                j = kmpNext[j];
            }

            i++;
            j++;
            if (x[i] == x[j]) {
                kmpNext[i] = kmpNext[j];
            } else {
                kmpNext[i] = j;
            }
        }
    }

    void compNext(char[] p, int m, int[] next) {
        next[0] = -1;
        int k = -1;
        for (int i = 1; i <= m; i++) {
            while (k >= 0 && p[k+1] != p[i]) {
                k = next[k];
            }

            next[i] = ++k;
        }
    }

    void patternMatching(char[] t, int n, char[] t, int m) {
        int k = 0;

        for (int i = 1; i <= n; i++) {
            while (k >= 0 && p[k+1] != t[i]) {
                k = next[k];
            }

            k++;
            if (k == m) {
                // p matches t[i-m+1..i]
                k = next[k];
            }
        }
    }

    void KMP(char[] x, int m, char[] y, int n) {
        int i, j, kmpNext[XSIZE];

        /* Preprocessing */
        preKmp(x, m, kmpNext);

        /* Searching */
        i = j = 0;
        while (j < n) {
            while (i > -1 && x[i] != y[j])  {
                i = kmpNext[i];
            }

            i++;
            j++;
            if (i >= m) {
                OUTPUT(j - 1);
                i = kmpNext(i);
            }
        }
    }
}
