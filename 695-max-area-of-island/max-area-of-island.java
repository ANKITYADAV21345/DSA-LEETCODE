//coding sphere
class Solution {

    public int dfs(int[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int count = 1;

        grid[i][j] = 0;

        count =count+ dfs(grid, i + 1, j);
        count =count+ dfs(grid, i - 1, j);
        count =count+ dfs(grid, i, j + 1);
        count =count+ dfs(grid, i, j - 1);

        return count;
    }

    public int maxAreaOfIsland(int[][] grid) {

        int max_size = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {

                    int island_size = dfs(grid, i, j);

                    if (island_size > max_size) {
                        max_size = island_size;
                    }
                }
            }
        }

        return max_size;
    }
}