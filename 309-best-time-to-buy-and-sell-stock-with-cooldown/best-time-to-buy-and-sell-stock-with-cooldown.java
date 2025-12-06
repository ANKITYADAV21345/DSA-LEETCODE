// CodeBix - Tabulation DP Version (Bottom-Up)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2]; 
        // n+2 because we will access dp[i+2]

        // Bottom-up fill
        for (int i = n - 1; i >= 0; i--) {

            // BUY state
            dp[i][0] = Math.max(
                -prices[i] + dp[i + 1][1],   // buy
                dp[i + 1][0]                // no buy
            );

            // SELL state
            dp[i][1] = Math.max(
                prices[i] + dp[i + 2][0],   // sell + cooldown
                dp[i + 1][1]                // no sell
            );
        }

        return dp[0][0]; // start from day 0 with buy allowed
    }
}
