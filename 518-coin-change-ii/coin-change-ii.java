//apne codebix vale recursion+memoisation ke code ko tabulation me convert kiya hai
class Solution {

    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];

        // If currentAmount = 0 → 1 way
        for (int index = 0; index <= n; index++) {
            dp[0][index] = 1;
        }

        for (int index = n - 1; index >= 0; index--) {

            for (int currAmount = 0; currAmount <= amount; currAmount++) {

                int include = 0;
                if (currAmount - coins[index] >= 0)
                    include = dp[currAmount - coins[index]][index];

                int exclude = dp[currAmount][index + 1];

                dp[currAmount][index] = include + exclude;
            }
        }

        return dp[amount][0];
    }
}