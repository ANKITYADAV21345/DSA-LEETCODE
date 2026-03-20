//algodaily
//20-03-2026
import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        int ans[][] = new int[row - k + 1][col - k + 1];

        for (int i = 0; i <= row - k; i++) {
            for (int j = 0; j <= col - k; j++) {

                HashSet<Integer> set = new HashSet<>();

                int min = Integer.MAX_VALUE;

                // traverse k*k window
                for (int l = i; l < i + k; l++) {
                    for (int m = j; m < j + k; m++) {
                        set.add(grid[l][m]);
                    }
                }

                List<Integer> list = new ArrayList<>(set);
                Collections.sort(list);

                for (int n = 1; n < list.size(); n++) {
                    min = Math.min(min, list.get(n) - list.get(n - 1));
                }

                ans[i][j] = (min == Integer.MAX_VALUE ? 0 : min);
            }
        }
        return ans;
    }
}