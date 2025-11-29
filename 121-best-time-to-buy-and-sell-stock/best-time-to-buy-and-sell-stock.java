// dp[i] = max profit possible till day i

//tabular
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];

        int minPrice = prices[0];
        dp[0] = 0; // No profit on first day

        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]); 
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }

        return dp[n - 1];
    }
}

