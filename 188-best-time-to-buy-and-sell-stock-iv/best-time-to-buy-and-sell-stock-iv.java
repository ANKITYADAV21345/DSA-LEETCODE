// CodeBix Optimized Recursive + Memoization
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        
        // Edge optimization
        if (k > n / 2) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    res += prices[i] - prices[i - 1];
            }
            return res;
        }

        Integer[][][] dp = new Integer[n][2][k + 1];
        
        return solve(0, 1, k, prices, dp);
    }

    private int solve(int index, int buy, int cap, int[] prices, Integer[][][] dp) {
        if (index == prices.length || cap == 0) 
            return 0;

        if (dp[index][buy][cap] != null)
            return dp[index][buy][cap];

        int profit = 0;

        if (buy == 1) {
            // Choice: Buy or Skip
            profit = Math.max(
                -prices[index] + solve(index + 1, 0, cap, prices, dp),
                solve(index + 1, 1, cap, prices, dp)
            );
        } else {
            // Choice: Sell or Skip
            profit = Math.max(
                prices[index] + solve(index + 1, 1, cap - 1, prices, dp),
                solve(index + 1, 0, cap, prices, dp)
            );
        }

        return dp[index][buy][cap] = profit;
    }
}
