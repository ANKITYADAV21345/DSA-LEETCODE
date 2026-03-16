// by algodaily
// 16-03-2026
class Solution {

    public int find(int[][] grid , int i , int j , int k ) {

        int n = grid.length;
        int m = grid[0].length;

        // Out of bound check
        if (i + 2 * k >= n || j + k >= m || j - k < 0) return -1;

        int row = i;
        int col = j;
        int sum = 0;

        // top → left
        for (int l = 0; l < k; l++) {
            sum = sum + grid[row + l][col - l];
        }

        // left → bottom
        row = i + k;
        col = j - k;

        for (int l = 0; l < k; l++) {
            sum = sum + grid[row + l][col + l];
        }

        // bottom → right
        row = i + 2 * k;
        col = j;

        for (int l = 0; l < k; l++) {
            sum = sum + grid[row - l][col + l];
        }

        // right → top
        row = i + k;
        col = j + k;

        for (int l = 0; l < k; l++) {
            sum = sum + grid[row - l][col - l];
        }

        return sum;
    }

    public int[] getBiggestThree(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                // Single cell rhombus
                if (set.add(grid[i][j])) {
                    pq.add(grid[i][j]);
                    if (pq.size() > 3) pq.remove();
                }

                for (int k = 1; k < (Math.min(row, col) / 2) + 1; k++) {

                    int sum = find(grid, i, j, k);

                    if (sum == -1) break;

                    if (set.add(sum)) {
                        pq.add(sum);
                        if (pq.size() > 3) pq.remove();
                    }
                }
            }
        }

        int n = pq.size();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = pq.remove();
        }

        return ans;
    }
}