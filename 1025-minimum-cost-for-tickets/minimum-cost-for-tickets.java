//tabulation
class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        int n = days.length;
        int[] dp = new int[n + 1];

        // base case
        dp[n] = 0;

        // fill table from back to front
        for (int i = n - 1; i >= 0; i--) {

            // 1-day pass
            int cost1 = costs[0] + dp[i + 1];

            // 7-day pass
            int j = i;
            while (j < n && days[j] < days[i] + 7) {
                j++;
            }
            int cost7 = costs[1] + dp[j];

            // 30-day pass
            j = i;
            while (j < n && days[j] < days[i] + 30) {
                j++;
            }
            int cost30 = costs[2] + dp[j];

            dp[i] = Math.min(cost1, Math.min(cost7, cost30));
        }

        return dp[0];
    }
}
