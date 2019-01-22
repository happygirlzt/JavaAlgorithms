/**
 * Created on 4 Oct 2018 by happygirlzt
 *
 */

public class Factorial {
    public int factorial(int n) {
        int[] dp = new int[n];

        // base case
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 1;
        } else {
            dp[n] = dp[n - 1] * n;
        }

        return dp[n];
    }
}
