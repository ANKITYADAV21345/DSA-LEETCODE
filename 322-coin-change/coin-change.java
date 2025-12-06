// Nikhil Lohiya - Recursion + Memoization
class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        int ans = rec(coins, amount, dp);
        return ans >= Integer.MAX_VALUE ? -1 : ans;
    }

    private int rec(int[] coins, int amount, Integer[] dp) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE; // impossible case

        if (dp[amount] != null)
            return dp[amount];

        int min = Integer.MAX_VALUE;

        // try each coin
        for (int coin : coins) {
            int result = rec(coins, amount - coin, dp);
            if (result != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + result);
            }
        }

        dp[amount] = min;
        return min;
    }
}
