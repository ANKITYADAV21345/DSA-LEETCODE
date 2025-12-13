class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];

        // Base case: amount = 0
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= n; j++) {

                // Exclude current coin
                dp[i][j] = dp[i][j - 1];

                // Include current coin
                if (i - coins[j - 1] >= 0) {
                    dp[i][j] += dp[i - coins[j - 1]][j];
                }
            }
        }

        return dp[amount][n];
    }
}

