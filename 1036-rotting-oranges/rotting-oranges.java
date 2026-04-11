//apna college  bfs ache se samajhega isme 

class Solution {

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        boolean[][] vis = new boolean[n][m];

        // queue -> ((i, j), time) sare wroten oranges store kare 
        Queue<int[]> queue = new LinkedList<>();

        // pushing all sources in queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                    vis[i][j] = true;
                }
            }
        }

        // bfs
        while (queue.size() > 0) {

            int[] front = queue.poll();

            int i = front[0];
            int j = front[1];
            int time = front[2];

            ans = Math.max(ans, time);

            // top(i-1,j)
            if (i - 1 >= 0 && !vis[i - 1][j] && grid[i - 1][j] == 1) {
                queue.add(new int[]{i - 1, j, time + 1});
                vis[i - 1][j] = true;
            }

            // right
            if (j + 1 < m && !vis[i][j + 1] && grid[i][j + 1] == 1) {
                queue.add(new int[]{i, j + 1, time + 1});
                vis[i][j + 1] = true;
            }

            // bottom
            if (i + 1 < n && !vis[i + 1][j] && grid[i + 1][j] == 1) {
                queue.add(new int[]{i + 1, j, time + 1});
                vis[i + 1][j] = true;
            }

            // left
            if (j - 1 >= 0 && !vis[i][j - 1] && grid[i][j - 1] == 1) {
                queue.add(new int[]{i, j - 1, time + 1});
                vis[i][j - 1] = true;
            }
        }

        // check for fresh orange
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    return -1;
                }
            }
        }

        return ans;
    }
}