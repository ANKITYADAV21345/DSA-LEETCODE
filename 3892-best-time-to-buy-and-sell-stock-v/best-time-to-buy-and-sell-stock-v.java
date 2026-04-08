//codestory with mik tabulation converted from previous recursion
//dp ka concept ache se clear kiya hai feel ke sath 
class Solution {
    public static long maximumProfit(int[] prices, int K) {
        int n = prices.length;

        long[][][] t = new long[n + 1][K + 1][3];

        // Base case: i == n
        for (int k = 0; k <= K; k++) {
            t[n][k][0] = 0;
            t[n][k][1] = Long.MIN_VALUE;
            t[n][k][2] = Long.MIN_VALUE;
        }

        // Fill DP table bottom-up
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0; k <= K; k++) {

                // CASE 0: no transaction in progress
                t[i][k][0] = t[i + 1][k][0]; // do nothing

                if (k > 0) {
                    if (t[i + 1][k][1] != Long.MIN_VALUE) {
                        t[i][k][0] = Math.max(t[i][k][0],
                        -prices[i] + t[i + 1][k][1]);
                    }

                    if (t[i + 1][k][2] != Long.MIN_VALUE) {
                    t[i][k][0] = Math.max(t[i][k][0],
                    prices[i] + t[i + 1][k][2]);
                    }
                }

                // CASE 1: holding long (bought already)
                t[i][k][1] = t[i + 1][k][1]; // hold

                if (k > 0 && t[i + 1][k - 1][0] != Long.MIN_VALUE) {
                    t[i][k][1] = Math.max(
                    t[i][k][1],
                    prices[i] + t[i + 1][k - 1][0]
                    );
                }

                // CASE 2: holding short
                t[i][k][2] = t[i + 1][k][2]; // hold

                
                if (k > 0 && t[i + 1][k - 1][0] != Long.MIN_VALUE) {
                    t[i][k][2] = Math.max(
                    t[i][k][2],
                    -prices[i] + t[i + 1][k - 1][0]
                    );
                }
            }
        }

        return t[0][K][0];
    }
}