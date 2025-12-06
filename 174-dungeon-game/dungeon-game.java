//tabulation
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        // dp[i][j] = minimum HP required to enter cell (i, j)
        // and still survive until reaching bottom-right
        int[][] dp = new int[n][m];

        // Last cell (Princess room)
        dp[n-1][m-1] = Math.max(1 - dungeon[n-1][m-1], 1);

        // Fill last row (only right direction possible)
        for (int j = m - 2; j >= 0; j--) {
            dp[n-1][j] = Math.max(dp[n-1][j+1] - dungeon[n-1][j], 1);
        }

        // Fill last column (only down direction possible)
        for (int i = n - 2; i >= 0; i--) {
            dp[i][m-1] = Math.max(dp[i+1][m-1] - dungeon[i][m-1], 1);
        }

        // Fill remaining grid (choose min health required path)
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                int minNext = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(minNext - dungeon[i][j], 1);
            }
        }

        // Minimum health required at start
        return dp[0][0];
    }
}
