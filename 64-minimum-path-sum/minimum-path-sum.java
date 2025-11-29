// solve(i, j) → (i, j) se last cell tak minimum sum

//recursion+memoisation
class Solution {
    int[][] memo;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(grid, 0, 0);
    }

    private int solve(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        // Base case: reach bottom-right cell
        if (i == m - 1 && j == n - 1)
            return grid[i][j];

        // Out of boundary case -> return very large value
        if (i >= m || j >= n)
            return Integer.MAX_VALUE;

        // Memoization check
        if (memo[i][j] != -1)
            return memo[i][j];

        // Recursive calls: right & down
        int right = solve(grid, i, j + 1);
        int down = solve(grid, i + 1, j);

        return memo[i][j] = grid[i][j] + Math.min(right, down);
    }
}
