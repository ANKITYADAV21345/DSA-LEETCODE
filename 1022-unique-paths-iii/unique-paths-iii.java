//similar question to no of island code story with mik yt
class Solution {
    int result = 0;
    int nonObsticle = 0;
    
    public int uniquePathsIII(int[][] grid) {
        int startRow = 0, startCol = 0;
        int n = grid.length, m = grid[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 1) 
                    nonObsticle++;

                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        
        solve(grid, 0, startRow, startCol);
        return result;
    }
    
    public void solve(int[][] grid, int count, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] == 3)
            return;
        
        if (grid[i][j] == 2) {
            if (count == nonObsticle) result++;
            return;
        }
        
        int temp = grid[i][j];
        grid[i][j] = 3;  // mark visited
        
        solve(grid, count + 1, i + 1, j);
        solve(grid, count + 1, i - 1, j);
        solve(grid, count + 1, i, j + 1);
        solve(grid, count + 1, i, j - 1);
        
        grid[i][j] = temp;  // backtrack
    }
}
