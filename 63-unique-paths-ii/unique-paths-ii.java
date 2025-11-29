// solve(i, j) → number of unique paths to reach destination (m-1, n-1)
//              from cell (i, j)

//recursion+memoisation
class Solution {
    int[][] memo;
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        memo = new int[m][n];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        
        return solve(obstacleGrid, 0, 0);
    }
    
    private int solve(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Out of bounds
        if(i >= m || j >= n)
            return 0;
        
        // If obstacle found
        if(grid[i][j] == 1)
            return 0;
        
        // Reached destination
        if(i == m - 1 && j == n - 1)
            return 1;
        
        // Memoization check
        if(memo[i][j] != -1)
            return memo[i][j];
        
        // Go right + Go down
        int right = solve(grid, i, j + 1);
        int down = solve(grid, i + 1, j);
        
        return memo[i][j] = right + down;
    }
}






