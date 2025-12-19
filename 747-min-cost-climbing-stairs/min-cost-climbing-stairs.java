class Solution {

    int[] memo;

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        memo = new int[n + 1];

        // -1 means not computed
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }

        return solve(cost, n);
    }

    private int solve(int[] cost, int i) {

        // base cases
        if (i == 0 || i == 1)
            return 0;

        if (memo[i] != -1)
            return memo[i];

        int oneStep = cost[i - 1] + solve(cost, i - 1);
        int twoStep = cost[i - 2] + solve(cost, i - 2);

        memo[i] = Math.min(oneStep, twoStep);
        return memo[i];
    }
}
