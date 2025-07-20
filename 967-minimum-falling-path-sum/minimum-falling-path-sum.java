//codebix
import java.util.HashMap;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < column; i++) {
            ans = Math.min(ans, rec(0, i, matrix, hm));
        }

        return ans; // This line was wrongly placed inside the loop
    }

    private static int rec(int i, int j, int[][] arr, HashMap<String, Integer> hm) {
        int row = arr.length;
        int column = arr[0].length;

        if (i == row) {
            return 0;
        }

        if (j < 0 || j >= column) {
            return Integer.MAX_VALUE;
        }

        String key = i + "codebix" + j;

        if (hm.containsKey(key)) {
            return hm.get(key);
        }

        int option1 = rec(i + 1, j - 1, arr, hm);
        int option2 = rec(i + 1, j, arr, hm);
        int option3 = rec(i + 1, j + 1, arr, hm);

        int minPath = arr[i][j] + Math.min(option1, Math.min(option2, option3));
        hm.put(key, minPath);

        return minPath;
    }
}
