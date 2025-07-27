//codebix
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length, n = grid[0].length;
        int[][] result = new int[m][n];

        // Initialize the bottom-right corner
        result[m - 1][n - 1] = grid[m - 1][n - 1];

        // Fill the last column
        for (int i = m - 2; i >= 0; i--) {
            result[i][n - 1] = grid[i][n - 1] + result[i + 1][n - 1];
        }

        // Fill the last row
        for (int j = n - 2; j >= 0; j--) {
            result[m - 1][j] = grid[m - 1][j] + result[m - 1][j + 1];
        }

        // Fill the rest of the grid
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                result[i][j] = grid[i][j] + Math.min(result[i + 1][j], result[i][j + 1]);
            }
        }

        return result[0][0];
    }
}
