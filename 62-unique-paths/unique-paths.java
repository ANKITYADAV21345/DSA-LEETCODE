class Solution {
    public static int solve(int i, int j, int m, int n, int[][] memo) {
        // Base case: if we go out of bounds, return 0
        if (i >= m || j >= n) return 0;
        // Base case: if we reach the bottom-right corner, return 1
        if (i == m - 1 && j == n - 1) return 1;
        // Return the memoized result if it exists
        if (memo[i][j] != -1) return memo[i][j];

        // Recursively calculate the number of unique paths from the current position
        memo[i][j] = solve(i + 1, j, m, n, memo) + solve(i, j + 1, m, n, memo);
        return memo[i][j];
    }

    public static int uniquePaths(int m, int n) {
        // Initialize memoization array
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1; // Fill with -1 to indicate uncomputed values
            }
        }
        // Start the recursive calculation from the top-left corner
        return solve(0, 0, m, n, memo);
    }
}
