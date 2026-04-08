//codestorywithmik 
//recursion
class Solution {
    static long[][][] dp;

    // CASE:
    // 0 -> nothing started
    // 1 -> normal buy done, need to sell
    // 2 -> short sell done, need to buy back

    static long solve(int i, int k, int state, int[] prices) {

        // base case
        if (i == prices.length) {
            if (state == 0) return 0;
            return Integer.MIN_VALUE; // invalid unfinished transaction
        }

        if (dp[i][k][state] != Long.MIN_VALUE) {
            return dp[i][k][state];
        }

        long take = Long.MIN_VALUE;
        long dontTake;

        // skip
        dontTake = solve(i + 1, k, state, prices);

        // take action
        if (k > 0) {

            if (state == 1) {
                // sell (complete normal transaction)
                take = prices[i] + solve(i + 1, k - 1, 0, prices);
            }
            else if (state == 2) {
                // buy back (complete short transaction)
                take = -prices[i] + solve(i + 1, k - 1, 0, prices);
            }
            else {
                // start transaction
                long buy = -prices[i] + solve(i + 1, k, 1, prices);
                long shortSell = prices[i] + solve(i + 1, k, 2, prices);

                take = Math.max(buy, shortSell);
            }
        }

        return dp[i][k][state] = Math.max(take, dontTake);
    }

    static long maximumProfit(int[] prices, int k) {
        int n = prices.length;

        dp = new long[n][k + 1][3];

        // initialize with Long.MIN_VALUE
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j], Long.MIN_VALUE);
            }
        }

        return solve(0, k, 0, prices);
    }
}