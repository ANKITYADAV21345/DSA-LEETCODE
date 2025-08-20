//codebix
class Solution {
    private int[][] dir = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};

    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Tour must start at top-left corner with 0
        if (grid[0][0] != 0) return false;

        int[] pos = {0, 0};  // starting position

        for (int step = 1; step < n * m; step++) {
            boolean found = false;
            for (int[] d : dir) {
                int newRow = pos[0] + d[0];
                int newCol = pos[1] + d[1];
                if (isValid(newRow, newCol, n, m) && grid[newRow][newCol] == step) {
                    pos[0] = newRow;
                    pos[1] = newCol;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }

        return true;
    }

    private boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}
