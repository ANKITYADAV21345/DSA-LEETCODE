//tabulation
class Solution {

    private int[][] dir = {
        {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
        {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
    };

    public double knightProbability(int n, int k, int row, int column) {

        double[][][] dp = new double[k + 1][n][n];

        // base case
        dp[0][row][column] = 1.0;

        for (int step = 1; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[step - 1][i][j] > 0) {
                        for (int d = 0; d < 8; d++) {
                            int ni = i + dir[d][0];
                            int nj = j + dir[d][1];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                dp[step][ni][nj] += dp[step - 1][i][j] / 8.0;
                            }
                        }
                    }
                }
            }
        }

        // sum of probabilities after k moves
        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += dp[k][i][j];
            }
        }

        return ans;
    }
}
