/**
 * Created on 18 May 2019 by happygirlzt
 *
 * Modified from CLRS
 *
 */

// Reference: https://web.stanford.edu/class/cs97si/10-string-algorithms.pdf

public class KMP {
    public int kmp(String t, String p) {
        int n = t.length();
        int m = p.length();
        if (m == 0) return 0;

        int[] pi = new int[m];
        computePrefix(p, pi);

        int k = -1;
        for (int i = 0; i < n; i++) {
            while (k >= 0 && p.charAt(k + 1) != t.charAt(i)) {
                k = pi[k];
            }

            if (p.charAt(k + 1) == t.charAt(i)) {
                k++;
            }

            if (k == m - 1) {
                return i - m + 1;
            }
        }

        return -1;
    }

    private void computePrefix(String p, int[] pi) {
        pi[0] = -1;
        int k = -1;
        int m = p.length();
        for (int i = 1; i < m; i++) {
            while (k >= 0 && p.charAt(k + 1) != p.charAt(i)) {
                k = pi[k];
            }

            if (p.charAt(k + 1) == p.charAt(i)) {
                k++;
            }

            pi[i] = k;
        }
    }
}
