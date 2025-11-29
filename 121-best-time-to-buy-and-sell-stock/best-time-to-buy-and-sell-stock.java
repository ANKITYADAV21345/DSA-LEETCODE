// solve(i, buyDone, minPrice)


//recursion +memoisation
class Solution {
    Integer[][] memo;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new Integer[n][3];
        return solve(prices, 0, 0);
    }

    private int solve(int[] prices, int i, int state) {
        if (i == prices.length) return 0;
        if (memo[i][state] != null) return memo[i][state];

        int profit = 0;

        if (state == 0) { 
            // Buy allowed
            int buy = -prices[i] + solve(prices, i + 1, 1);
            int skip = solve(prices, i + 1, 0);
            profit = Math.max(buy, skip);

        } else if (state == 1) { 
            // Holding stock
            int sell = prices[i] + solve(prices, i + 1, 2);
            int hold = solve(prices, i + 1, 1);
            profit = Math.max(sell, hold);

        } else { 
            // state == 2 -> already sold, no buy allowed
            profit = solve(prices, i + 1, 2);
        }

        return memo[i][state] = profit;
    }
}
